package com.nsbm.echannelling.patientservice.controller;

import com.nsbm.echannelling.patientservice.model.Patient_Appoinment;
import com.nsbm.echannelling.patientservice.service.Patient_AppoinmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
@Service
public class Patient_AppoinmentController {
    @Autowired
    private Patient_AppoinmentService patient_appoinmentService;

    @PostMapping("/book")
    public Patient_Appoinment bookAppointment(@RequestBody Patient_Appoinment appointment) {
        return patient_appoinmentService.bookAppointment(appointment);
    }

    @GetMapping("/{id}")
    public Patient_Appoinment getAppointmentById(@PathVariable Long id) {
        return patient_appoinmentService.getAppointmentById(id).orElse(null);
    }

    @GetMapping
    public List<Patient_Appoinment> getAllAppointments() {
        return patient_appoinmentService.getAllAppointments();
    }


}
