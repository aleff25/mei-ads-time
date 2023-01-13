package pt.iscte.mei.school.classrooms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pt.iscte.mei.school.classrooms.model.Classroom;

import java.util.List;

public interface ClassroomRepository extends JpaRepository<Classroom, String> {

    List<Classroom> findAllByNameLikeIgnoreCase(String name);

    boolean existsByName(String name);

    Classroom findByName(String name);
}
