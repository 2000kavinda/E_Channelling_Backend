package com.nsbm.echannelling.adminservice.service;

import com.nsbm.echannelling.adminservice.model.Patient;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PatientService {
    ResponseEntity<?> getAllPatients();

    ResponseEntity<?> updatePatient(Long pId, Patient newPatient);

    ResponseEntity<?>  deletePatient(Long pId);

    List<Patient> searchPatientsByName(String name);
}
