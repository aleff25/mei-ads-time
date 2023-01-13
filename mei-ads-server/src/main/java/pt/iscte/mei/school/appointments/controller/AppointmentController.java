package pt.iscte.mei.school.appointments.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pt.iscte.mei.school.appointments.application.AppointmentApplicationService;
import pt.iscte.mei.school.appointments.application.dto.RegisterAppointmentDTO;
import pt.iscte.mei.school.appointments.model.Appointment;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/appointments")
public class AppointmentController {

    @Autowired
    private AppointmentApplicationService service;

    @PostMapping()
    public ResponseEntity<Void> create(@Valid @RequestBody RegisterAppointmentDTO dto) {
        service.register(dto);

        return ResponseEntity.ok().build();
    }

    @GetMapping()
    public ResponseEntity<List<Appointment>> findAll() {
        List<Appointment> appointments = service.searchAll();

        return ResponseEntity.ok(appointments);
    }

}