package com.nsbm.echannelling.patientservice.service;

import com.nsbm.echannelling.patientservice.model.PatientAppoinment;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface PatientAppoinmentService {
    ResponseEntity<?> bookAppointment(PatientAppoinment appointment);

    Optional<PatientAppoinment> getAppointmentById(Long id);

    List<PatientAppoinment> getAllAppointments();
}
