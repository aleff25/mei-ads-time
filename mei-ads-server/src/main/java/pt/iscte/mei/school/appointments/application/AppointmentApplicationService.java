package pt.iscte.mei.school.appointments.application;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pt.iscte.mei.school.appointments.application.dto.RegisterAppointmentDTO;
import pt.iscte.mei.school.appointments.application.dto.SearchAppointmentDTO;
import pt.iscte.mei.school.appointments.exception.MeiAdsSchoolAppointmentAlreadyRegisteredException;
import pt.iscte.mei.school.appointments.exception.MeiAdsSchoolAppointmentClassroomAlreadyRegisteredException;
import pt.iscte.mei.school.appointments.exception.MeiAdsSchoolAppointmentNotPermittedException;
import pt.iscte.mei.school.appointments.model.Appointment;
import pt.iscte.mei.school.appointments.repository.AppointmentRepository;
import pt.iscte.mei.school.classrooms.application.ClassroomApplicationService;
import pt.iscte.mei.school.classrooms.model.Classroom;
import pt.iscte.mei.school.courses.application.CourseApplicationService;
import pt.iscte.mei.school.courses.model.Course;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor
@Log4j2
public class AppointmentApplicationService {

    private final AppointmentRepository repository;
    private final ClassroomApplicationService classroomService;
    private final CourseApplicationService courseService;

    public void register(RegisterAppointmentDTO dto) {

        List<Appointment> appointments = new ArrayList<>();
        for (int index = 0; index < dto.getStartDates().size(); index++) {
            var appointment = Appointment.builder()
                    .startDate(dto.getStartDates().get(index))
                    .endDate(dto.getEndDates().get(index))
                    .capacityRequired(dto.getCapacity())
                    .curricularUnit(dto.getCurricularUnitId())
                    .classroom(dto.getClassroomId())
                    .course(dto.getCourseId())
                    .build();

            appointments.add(appointment);
        }

        appointments.forEach(this::register);
    }

    public void register(Appointment appointment) {
        log.info("Saving new appointment = {}", appointment);

        LocalDateTime startDate = appointment.getStartDate();
        LocalDateTime endDate = appointment.getEndDate();

        if (ChronoUnit.HOURS.between(startDate, endDate) > 1 &&
                ChronoUnit.MINUTES.between(startDate, endDate) % 30 == 1) {
            throw new MeiAdsSchoolAppointmentNotPermittedException();
        }

        if (startDate.getDayOfWeek().equals(DayOfWeek.SUNDAY) ||
                (startDate.getDayOfWeek().equals(DayOfWeek.SATURDAY) &&
                        startDate.getHour() > 13)
        ) {
            throw new MeiAdsSchoolAppointmentNotPermittedException();
        }

        if (appointment.getClassroom() != null) {
            Classroom classroom = classroomService.searchById(appointment.getClassroom());

            List<Appointment> appointmentsClassroom = repository.getAllBetweenDatesAndClassroom(startDate,
                    endDate, classroom.getId());

            if (!appointmentsClassroom.isEmpty()) {
                throw new MeiAdsSchoolAppointmentClassroomAlreadyRegisteredException();
            }
        }

        List<Appointment> appointmentsRegistered = repository.getAllBetweenDates(startDate,
                endDate);

        if (!appointmentsRegistered.isEmpty() && appointment.getCurricularUnit() != null) {
            int appointmentCurricularUnits =
                    (int) appointmentsRegistered.stream().filter(a -> a.getCurricularUnit().equals(appointment.getCurricularUnit())).count();

            if (appointmentCurricularUnits > 3) {
                throw new MeiAdsSchoolAppointmentAlreadyRegisteredException();
            }
        }

        repository.saveAndFlush(appointment);
    }

    public List<Appointment> search(SearchAppointmentDTO dto) {
        log.info("Searching all appointments with dates between {} and {}", dto.getStartDate(), dto.getEndDate());

        return repository.getAllBetweenDates(dto.getStartDate(),
                dto.getEndDate());
    }


    public List<Appointment> searchAll() {
        log.info("Searching all appointments");

        return repository.findAll();
    }

    public Appointment findById(String id) {
        log.info("Searching appointment by id= [{}]", id);

        return repository.findById(id).orElseThrow(MeiAdsSchoolAppointmentNotPermittedException::new);
    }

    public void update(Appointment appointment) {
        log.info("Updating appointment by id= [{}]", appointment.getId());

        repository.save(appointment);
    }
}
