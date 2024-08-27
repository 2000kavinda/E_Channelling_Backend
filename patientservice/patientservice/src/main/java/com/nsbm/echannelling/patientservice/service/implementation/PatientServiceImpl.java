package com.nsbm.echannelling.patientservice.service.implementation;

import com.nsbm.echannelling.patientservice.model.Patient;
import com.nsbm.echannelling.patientservice.repository.PatientRepo;
import com.nsbm.echannelling.patientservice.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientServiceImpl implements PatientService {
    @Autowired
    private PatientRepo  patientrepo ;

    /**
     * NO NEED FOR THE PATIENTS
     * @return
     */
    @Override
    public List<Patient> getAllPatients() {
        return patientrepo.findAll();
    }

    /**
     *want API 01
     * @param id
     * @return
     */
    @Override
    public Optional<Patient> getPatientById(Long id) {
        return patientrepo.findById(id);
    }

    /**
     *WANT API 02
     * @param patient
     * @return
     */
    @Override
    public Patient savePatient(Patient patient) {
        return patientrepo.save(patient);
    }

    /**
     * WANT API 03
     * @param id
     * @param patient
     * @return
     */
    @Override
    public Patient updatePatient(Long id, Patient patient) {
        patient.setPatient_id(id);
        return patientrepo.save(patient);
    }
}
