package pt.iscte.mei.school.students.model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;

@Data
@Table(name = "students")
@Entity
@NoArgsConstructor
public class Student {

    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String id;
    private String name;
    private String courseId;
    private String classroomId;

    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date updatedAt;

    @Builder
    public Student(final String id, final String name, final String courseId, final String classroomId) {
        this.id = id;
        this.name = name;
        this.courseId = courseId;
        this.classroomId = classroomId;
    }
}
