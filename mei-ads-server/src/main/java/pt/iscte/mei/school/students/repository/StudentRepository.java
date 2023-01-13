package pt.iscte.mei.school.students.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pt.iscte.mei.school.students.model.Student;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, String> {

    List<Student> findAllByNameLikeIgnoreCase(String name);
}
