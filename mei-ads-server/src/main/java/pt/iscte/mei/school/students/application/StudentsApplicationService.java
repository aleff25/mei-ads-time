package pt.iscte.mei.school.students.application;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pt.iscte.mei.school.students.model.Student;
import pt.iscte.mei.school.students.repository.StudentRepository;

import java.util.List;


@Service
@Transactional
@AllArgsConstructor
@Log4j2
public class StudentsApplicationService {

    private final StudentRepository repository;

    private List<Student> searchAll() {
        log.info("Searching all students");
        return repository.findAll();
    }

    private List<Student> searchByName(String name) {
        log.info("Searching students by name = {}", name);

        return repository.findAllByNameLikeIgnoreCase(name);
    }
}
