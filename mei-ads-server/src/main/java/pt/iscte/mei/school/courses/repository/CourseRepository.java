package pt.iscte.mei.school.courses.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pt.iscte.mei.school.courses.model.Course;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, String> {

    List<Course> findAllByNameLikeIgnoreCase(String name);

    boolean existsByName(String name);

    Course findByName(String name);
}
