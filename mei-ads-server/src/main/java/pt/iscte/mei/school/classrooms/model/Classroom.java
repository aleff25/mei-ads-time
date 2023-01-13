package pt.iscte.mei.school.classrooms.model;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;

@Getter
@Table(name = "classrooms")
@Entity
@EqualsAndHashCode
@NoArgsConstructor
public class Classroom {

    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String id;
    private String name;
    private int capacity;

    //TODO: See how this column is create in h2 database
    @ElementCollection
    private List<String> caracteristics;

    @Builder
    public Classroom(final String id, final String name, final int capacity, final List<String> caracteristics) {
        this.id = id;
        this.name = name;
        this.capacity = capacity;
        this.caracteristics = caracteristics;
    }
}
