package com.nsbm.echannelling.patientservice.service;

import com.nsbm.echannelling.patientservice.model.PatientAppoinment;

import java.util.List;
import java.util.Optional;

public interface PatientAppoinmentService {
    PatientAppoinment bookAppointment(PatientAppoinment appointment);

    Optional<PatientAppoinment> getAppointmentById(Long id);

    List<PatientAppoinment> getAllAppointments();
}
