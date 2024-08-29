package com.nsbm.echannelling.patientservice.service;

import com.nsbm.echannelling.patientservice.model.Patient;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface PatientService {
    //NO NEED FOR THE PATIENTS
    List<Patient> getAllPatients();

    //want API 01
    Optional<Patient> getPatientById(Long id);

    // WANT API 02
    ResponseEntity<?> savePatient(Patient patient);

    //WANT API 03
    ResponseEntity<?> updatePatient(Long id, Patient patient);
}
