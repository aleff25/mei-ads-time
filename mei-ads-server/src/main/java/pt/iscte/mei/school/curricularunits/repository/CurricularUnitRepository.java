package pt.iscte.mei.school.curricularunits.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pt.iscte.mei.school.courses.model.Course;
import pt.iscte.mei.school.curricularunits.model.CurricularUnit;

import java.util.List;

public interface CurricularUnitRepository extends JpaRepository<CurricularUnit, String> {

    List<CurricularUnit> findAllByNameLikeIgnoreCase(String name);

    boolean existsByName(String name);

    CurricularUnit findByName(String name);
}
