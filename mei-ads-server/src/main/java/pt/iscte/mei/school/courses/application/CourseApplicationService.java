package pt.iscte.mei.school.courses.application;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pt.iscte.mei.school.classrooms.model.Classroom;
import pt.iscte.mei.school.courses.model.Course;
import pt.iscte.mei.school.courses.repository.CourseRepository;
import pt.iscte.mei.school.features.model.Feature;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
@Log4j2
public class CourseApplicationService {

    private final CourseRepository repository;

    public List<Course> searchAll() {
        log.info("Searching all courses");
        return repository.findAll();
    }

    public List<Course> searchByName(String name) {
        log.info("Searching course by name = {}", name);

        return repository.findAllByNameLikeIgnoreCase(name);
    }

    public Course searchById(String id) {
        log.info("Searching course by id = {}", id);

        return repository.findById(id).get();
    }

    public Course saveIfNotExists(Course course) {
        String name = course.getName();
        if (!repository.existsByName(name)) {
            return repository.save(course);
        }

        return repository.findByName(name);
    }
}
