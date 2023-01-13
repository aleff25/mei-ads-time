package pt.iscte.mei.school.features.model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@Table(name = "features")
@Entity
@NoArgsConstructor
public class Feature {

    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String id;

    private String name;

    @Builder
    public Feature(final String id, final String name) {
        this.id = id;
        this.name = name;
    }
}
