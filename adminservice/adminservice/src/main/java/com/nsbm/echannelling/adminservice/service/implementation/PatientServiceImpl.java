package com.nsbm.echannelling.adminservice.service.implementation;

import com.nsbm.echannelling.adminservice.model.Patient;
import com.nsbm.echannelling.adminservice.repository.CredentialsRepository;
import com.nsbm.echannelling.adminservice.repository.PatientRepository;
import com.nsbm.echannelling.adminservice.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private CredentialsRepository credentialsRepository;

    //view all patients
    @Override
    public ResponseEntity<?> getAllPatients() {
        try {
            return  ResponseEntity.ok(patientRepository.findAll());

        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    /**
     * get full details for specific patient
     * @param pId
     * @return
     */
    @Override
    public ResponseEntity<?> getAPatient(Long pId) {
        try {
            return  ResponseEntity.ok(patientRepository.findById(pId));

        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    /**
     * update existing patient information
     * @param pId
     * @param newPatient
     * @return
     */
    @Override
    public ResponseEntity<?>  updatePatient(Long pId, Patient newPatient) {
        try {
            Optional<Patient> credentialOptional = patientRepository.findById(pId);
            Patient patient = credentialOptional.get();
            patient.setPName(newPatient.getPName());
            patient.setBDay(newPatient.getBDay());
            patient.setGender(newPatient.getGender());
            patient.setContact(newPatient.getContact());

            return  ResponseEntity.ok(patientRepository.save(patient));

        } catch (Exception e) {

            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    /**
     * delete existing patient from patient and credential DBs
     * @param pId
     * @return
     */
    @Override
    public ResponseEntity<?>  deletePatient(Long pId) {
        try {
            Optional<Patient> credentialOptional = patientRepository.findById(pId);
            if (credentialOptional.isPresent())
            {
                patientRepository.deleteById(pId);
                credentialsRepository.deleteById(pId);

                return ResponseEntity.ok("Patient deleted successfully");
            }else {
                return ResponseEntity.ok("Patient not found");
            }

        } catch (Exception e) {

            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    //search patient by name
    @Override
    public ResponseEntity<?> searchPatientsByName(String name) {
        try {
            return ResponseEntity.ok(patientRepository.findByNameContaining(name));
        }catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
