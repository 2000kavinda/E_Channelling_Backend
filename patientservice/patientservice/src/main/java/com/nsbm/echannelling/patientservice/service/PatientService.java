package com.nsbm.echannelling.patientservice.service;

import com.nsbm.echannelling.patientservice.model.Patient;
import com.nsbm.echannelling.patientservice.repository.PatientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {
    @Autowired
    private PatientRepo  patientrepo ;

    //NO NEED FOR THE PATIENTS
    public List<Patient> getAllPatients() {
        return patientrepo.findAll();
    }

    //want API 01
    public Optional<Patient> getPatientById(Long id) {
        return patientrepo.findById(id);
    }
    // WANT API 02
    public Patient savePatient(Patient patient) {
        return patientrepo.save(patient);
    }

    //WANT API 03
    public Patient updatePatient(Long id, Patient patient) {
        patient.setPatient_id(id);
        return patientrepo.save(patient);
    }
}
