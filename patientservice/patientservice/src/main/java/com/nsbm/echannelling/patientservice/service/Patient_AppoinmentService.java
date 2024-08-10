package com.nsbm.echannelling.patientservice.service;

import com.nsbm.echannelling.patientservice.model.Patient_Appoinment;

import java.util.List;
import java.util.Optional;

public interface Patient_AppoinmentService {
    Patient_Appoinment bookAppointment(Patient_Appoinment appointment);

    Optional<Patient_Appoinment> getAppointmentById(Long id);

    List<Patient_Appoinment> getAllAppointments();
}
