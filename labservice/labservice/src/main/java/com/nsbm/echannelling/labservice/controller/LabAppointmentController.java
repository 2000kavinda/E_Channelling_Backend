package com.nsbm.echannelling.labservice.controller;

import com.nsbm.echannelling.labservice.model.LabAppointmentModel;
import com.nsbm.echannelling.labservice.service.LabAppointmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Laboratory")
public class LabAppointmentController {
    @Autowired
    private LabAppointmentServiceImpl labAppointmentService;

    @PostMapping("/add")
    public ResponseEntity<String> add(@RequestBody LabAppointmentModel labAppointmentModel) {
        labAppointmentService.saveAppointment(labAppointmentModel);
        return new ResponseEntity<>("Appointment added successfully", HttpStatus.OK);
    }

    @GetMapping("/appointments")
    public ResponseEntity<List<LabAppointmentModel>> getAllAppointments() {
        List<LabAppointmentModel> appointments = labAppointmentService.getAllAppointments();
        return new ResponseEntity<>(appointments, HttpStatus.OK);
    }

    @GetMapping("/appointments/{id}")
    public ResponseEntity<LabAppointmentModel> getAppointmentById(@PathVariable Long id) {
        LabAppointmentModel appointment = labAppointmentService.getAppointmentById(id);
        return new ResponseEntity<>(appointment, HttpStatus.OK);
    }

    @DeleteMapping("/appointments/{id}")
    public ResponseEntity<String> deleteAppointment(@PathVariable Long id) {
        labAppointmentService.deleteAppointment(id);
        return new ResponseEntity<>("Appointment deleted successfully", HttpStatus.OK);
    }
    add comments
}
