package pt.iscte.mei.school.appointments.application.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import pt.iscte.mei.school.appointments.model.Appointment;
import pt.iscte.mei.school.classrooms.model.Classroom;
import pt.iscte.mei.school.courses.model.Course;
import pt.iscte.mei.school.curricularunits.model.CurricularUnit;
import pt.iscte.mei.school.features.model.Feature;

@Getter
@AllArgsConstructor(staticName = "from")
public class ReadXLSXFileAppointmentDTO {

    private Course course;

    private Appointment appointment;

    private Classroom classroom;

    private CurricularUnit curricularUnit;

    private Feature feature;
}
