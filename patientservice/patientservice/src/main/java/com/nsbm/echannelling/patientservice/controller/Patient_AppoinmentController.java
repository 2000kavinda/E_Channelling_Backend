package com.nsbm.echannelling.patientservice.controller;

import com.nsbm.echannelling.patientservice.model.Patient_Appoinment;
import com.nsbm.echannelling.patientservice.model.Patient_Doctor;
import com.nsbm.echannelling.patientservice.service.Patient_AppoinmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/appointments")
public class Patient_AppoinmentController {
    @Autowired
    private Patient_AppoinmentService patient_appoinmentService;

    @PostMapping("/book")
    public ResponseEntity<String> bookAppointment(@RequestBody Patient_Appoinment appointment) {
        Patient_Appoinment savedAppointment = patient_appoinmentService.bookAppointment(appointment);
        if (savedAppointment != null) {
            return ResponseEntity.ok("Appointment successfully booked.");
        } else {
            return ResponseEntity.status(500).body("Failed to book appointment.");
        }
    }

    @GetMapping("/{id}")
    public Patient_Appoinment getAppointmentById(@PathVariable Long id) {
        return patient_appoinmentService.getAppointmentById(id).orElse(null);
    }


    // Api for the Hiran doctor side -->Appoinment list
    // Endpoint to get all booked appointments
    @GetMapping("/all")
    public List<Patient_Appoinment> getAllAppointments() {
        return patient_appoinmentService.getAllAppointments();
    }
}