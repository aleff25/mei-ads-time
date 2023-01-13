package pt.iscte.mei.school.files.excel.helper;

import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;
import pt.iscte.mei.school.appointments.application.dto.ReadXLSXFileAppointmentDTO;
import pt.iscte.mei.school.appointments.model.Appointment;
import pt.iscte.mei.school.classrooms.model.Classroom;
import pt.iscte.mei.school.courses.model.Course;
import pt.iscte.mei.school.courses.model.Shift;
import pt.iscte.mei.school.curricularunits.model.CurricularUnit;
import pt.iscte.mei.school.features.model.Feature;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Slf4j
public class ExcelHelper {

    public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
    static String[] HEADERs = {"Id", "Title", "Description", "Published"};
    static String SHEET = "Turnos";

    public static boolean hasExcelFormat(MultipartFile file) {

        if (!TYPE.equals(file.getContentType())) {
            return false;
        }

        return true;
    }

    public static ByteArrayInputStream appointmentsToExcel(List<Appointment> appointments) {

        try (Workbook workbook = new XSSFWorkbook(); ByteArrayOutputStream out = new ByteArrayOutputStream();) {
            Sheet sheet = workbook.createSheet(SHEET);

            // Header
            Row headerRow = sheet.createRow(0);

            for (int col = 0; col < HEADERs.length; col++) {
                Cell cell = headerRow.createCell(col);
                cell.setCellValue(HEADERs[col]);
            }

            int rowIdx = 1;
            for (Appointment tutorial : appointments) {
                Row row = sheet.createRow(rowIdx++);

                //TODO: Add others values to fill the cells
                row.createCell(0).setCellValue(tutorial.getId());
            }

            workbook.write(out);
            return new ByteArrayInputStream(out.toByteArray());
        } catch (IOException e) {
            throw new RuntimeException("fail to import data to Excel file: " + e.getMessage());
        }
    }

    public static List<ReadXLSXFileAppointmentDTO> excelToAppointments(InputStream is) {

        Workbook workbook = null;
        try {
            workbook = new XSSFWorkbook(is);

            Sheet sheet = workbook.getSheetAt(0);
            DataFormatter dataFormatter = new DataFormatter();
            List<ReadXLSXFileAppointmentDTO> data = new ArrayList<>();

            int index = 0;
            for (Row row : sheet) {
                if (index++ == 0) continue;

                Course course = Course.builder()
                        .name(dataFormatter.formatCellValue(row.getCell(3)))
                        .location(dataFormatter.formatCellValue(row.getCell(0)))
                        .shift(Shift.PostWork)
                        .capacity(convertToInteger(dataFormatter.formatCellValue(row.getCell(4))))
                        .build();

                CurricularUnit curricularUnit = CurricularUnit.builder()
                        .name(dataFormatter.formatCellValue(row.getCell(1)))
                        .build();

                Classroom classroom = Classroom.builder()
                        .name(dataFormatter.formatCellValue(row.getCell(12)))
                        .capacity(convertToInteger(dataFormatter.formatCellValue(row.getCell(13))))
                        .build();

                String startHour = dataFormatter.formatCellValue(row.getCell(8));
                String endHour = dataFormatter.formatCellValue(row.getCell(9));
                Date appointmentDate = row.getCell(10).getDateCellValue();

                appointmentDate.setTime(Long.parseLong(startHour.split(":")[0]));
                LocalDateTime startAppointmentDate = appointmentDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();

                appointmentDate.setTime(Long.parseLong(endHour.split(":")[0]));
                LocalDateTime endAppointmentDate = appointmentDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();


                Appointment appointment = Appointment.builder()
                        .startDate(startAppointmentDate)
                        .endDate(endAppointmentDate)
                        .build();

                Feature feature = Feature.builder()
                        .name(dataFormatter.formatCellValue(row.getCell(11)))
                        .build();

                ReadXLSXFileAppointmentDTO dto = ReadXLSXFileAppointmentDTO.from(course,
                        appointment, classroom, curricularUnit, feature);

                data.add(dto);
            }

            workbook.close();

            return data;
        } catch (IOException e) {
            throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
        } finally {
            try {
                if (workbook != null) workbook.close();
            } catch (IOException e) {
                log.error(e.getMessage(), e);
            }
        }
    }

    private static int convertToInteger(String value) {
        try {
            return value != null ? Integer.parseInt(value) : 0;
        } catch (Exception ex) {
            return 0;
        }
    }
}
