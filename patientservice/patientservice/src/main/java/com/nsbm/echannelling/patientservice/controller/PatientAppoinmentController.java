package com.nsbm.echannelling.patientservice.controller;

import com.nsbm.echannelling.patientservice.model.PatientAppoinment;
import com.nsbm.echannelling.patientservice.service.implementation.PatientAppoinmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/appointments")
public class PatientAppoinmentController {
    @Autowired
    private PatientAppoinmentServiceImpl patient_appoinmentService;

    @PostMapping("/book")
    public ResponseEntity<String> bookAppointment(@RequestBody PatientAppoinment appointment) {
        PatientAppoinment savedAppointment = patient_appoinmentService.bookAppointment(appointment);
        if (savedAppointment != null) {
            return ResponseEntity.ok("Appointment successfully booked.");
        } else {
            return ResponseEntity.status(500).body("Failed to book appointment.");
        }
    }

    @GetMapping("/{id}")
    public PatientAppoinment getAppointmentById(@PathVariable Long id) {
        return patient_appoinmentService.getAppointmentById(id).orElse(null);
    }


    // Api for the Hiran doctor side -->Appoinment list
    // Endpoint to get all booked appointments
    @GetMapping("/all")
    public List<PatientAppoinment> getAllAppointments() {
        return patient_appoinmentService.getAllAppointments();
    }
}