package com.nsbm.echannelling.patientservice.controller;

import com.nsbm.echannelling.patientservice.model.PatientAppoinment;
import com.nsbm.echannelling.patientservice.service.implementation.PatientAppoinmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/api/appointments")
public class PatientAppoinmentController {

    /**
     *Injects the PatientAppoinmentServiceImpl into the controller
     */
    @Autowired
    private PatientAppoinmentServiceImpl patient_appoinmentService;

    /**
     * Endpoint to book a new appointment.
     *Accepts a PatientAppoinment object in the request body and perform save it.
     * @param appointment
     * @return
     */
    @PostMapping("/book")
    public ResponseEntity<?> bookAppointment(@RequestBody PatientAppoinment appointment) {
        ResponseEntity<?> savedAppointment = patient_appoinmentService.bookAppointment(appointment);
        if (savedAppointment != null) {
            return ResponseEntity.ok("Appointment successfully booked.");
        } else {
            return ResponseEntity.status(500).body("Failed to book appointment.");
        }
    }

    /**
     * Endpoint to retrieve a specific appointment by its Appoinment ID.
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public PatientAppoinment getAppointmentById(@PathVariable Long id) {
        return patient_appoinmentService.getAppointmentById(id).orElse(null);
    }

    /**
     * Api for the Hiran doctor side -->Appoinment list
     * Endpoint to get all booked appointments
     * @return
     */
    @GetMapping("/all")
    public List<PatientAppoinment> getAllAppointments() {
        return patient_appoinmentService.getAllAppointments();
    }
}