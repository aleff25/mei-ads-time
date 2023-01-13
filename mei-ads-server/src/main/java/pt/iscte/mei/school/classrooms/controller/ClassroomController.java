package pt.iscte.mei.school.classrooms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pt.iscte.mei.school.classrooms.application.ClassroomApplicationService;
import pt.iscte.mei.school.classrooms.model.Classroom;

import java.util.List;

@RestController
@RequestMapping(path = "/classrooms")
public class ClassroomController {

    @Autowired
    private ClassroomApplicationService service;

    @GetMapping()
    public ResponseEntity<List<Classroom>> findAll() {
        List<Classroom> courses = service.searchAll();

        return ResponseEntity.ok().body(courses);
    }

}