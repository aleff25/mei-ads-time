package pt.iscte.mei.school.courses.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pt.iscte.mei.school.courses.application.CourseApplicationService;
import pt.iscte.mei.school.courses.model.Course;

import java.util.List;

@RestController
@RequestMapping(path = "/courses")
public class CourseController {

    @Autowired
    private CourseApplicationService service;

    @GetMapping()
    public ResponseEntity<List<Course>> findAll() {
        List<Course> courses = service.searchAll();

        return ResponseEntity.ok().body(courses);
    }

}