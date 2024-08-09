package com.nsbm.echannelling.adminservice.service;

import com.nsbm.echannelling.adminservice.dto.ScheduleDTO;
import com.nsbm.echannelling.adminservice.model.Patient;
import com.nsbm.echannelling.adminservice.model.Schedule;
import com.nsbm.echannelling.adminservice.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    public ResponseEntity<?> getAllPatients() {
        try {
            return  ResponseEntity.ok(patientRepository.findAll());

        } catch (Exception e) {

            return ResponseEntity.badRequest().body("Something went wrong");
        }
    }

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

    public ResponseEntity<?>  deletePatient(Long pId) {
        try {
            Optional<Patient> credentialOptional = patientRepository.findById(pId);
            if (credentialOptional.isPresent())
            {
                patientRepository.deleteById(pId);

                return ResponseEntity.ok("Patient deleted successfully");
            }else {
                return ResponseEntity.ok("Patient not found");
            }

        } catch (Exception e) {

            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    public List<Patient> searchPatientsByName(String name) {
        return patientRepository.findByNameContaining(name);
    }
}
