package pt.iscte.mei.school.appointments.model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import pt.iscte.mei.school.classrooms.model.Caracteristic;
import pt.iscte.mei.school.classrooms.model.Classroom;
import pt.iscte.mei.school.courses.model.Course;
import pt.iscte.mei.school.curricularunits.model.CurricularUnit;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.List;


@Data
@Table(name = "appointments")
@Entity
@NoArgsConstructor
public class Appointment {

    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String id;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private int capacityRequired;
    private String curricularUnit;

    @JoinColumn(name = "curricularUnit", insertable = false, updatable = false)
    @OneToOne(targetEntity = CurricularUnit.class, fetch = FetchType.EAGER)
    private CurricularUnit curricularUnitEntity;

    private String classroom;

    @JoinColumn(name = "classroom", insertable = false, updatable = false)
    @OneToOne(targetEntity = Classroom.class, fetch = FetchType.EAGER)
    private Classroom classroomEntity;

    private String course;

    @JoinColumn(name = "course", insertable = false, updatable = false)
    @OneToOne(targetEntity = Course.class, fetch = FetchType.EAGER)
    private Course courseEntity;

    @ElementCollection
    private List<String> caracteristic;
    private boolean supervisionalApproval;

    @Builder
    public Appointment(final LocalDateTime startDate, final LocalDateTime endDate, final int capacityRequired,
                       final String curricularUnit, final String classroom, final String course,
                       final List<String> caracteristic,
                       final boolean supervisionalApproval) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.capacityRequired = capacityRequired;
        this.curricularUnit = curricularUnit;
        this.classroom = classroom;
        this.course = course;
        this.caracteristic = caracteristic;
        this.supervisionalApproval = supervisionalApproval;
    }
}
