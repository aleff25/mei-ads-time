package pt.iscte.mei.school.curricularunits.model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@Table(name = "curricular_units")
@Entity
@NoArgsConstructor
public class CurricularUnit {

    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String id;

    private String name;

    @Builder
    public CurricularUnit(final String id, final String name) {
        this.id = id;
        this.name = name;
    }
}
