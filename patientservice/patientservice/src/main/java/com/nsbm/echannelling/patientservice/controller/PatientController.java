package com.nsbm.echannelling.patientservice.controller;

import com.nsbm.echannelling.patientservice.model.Patient;
import com.nsbm.echannelling.patientservice.service.implementation.PatientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/api/patients")
public class PatientController {
    /**
     * Injects the PatientServiceImpl into the controller
     */
    @Autowired
    private PatientServiceImpl patientService;

    /**
     * Endpoint to retrieve all patients.
     * @return
     */
    @GetMapping
    public List<Patient> getAllPatients() {
        return patientService.getAllPatients();
    }

    /**
     * Endpoint to retrieve a specific patient by their Patient ID.
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public ResponseEntity<Patient> getPatientById(@PathVariable Long id) {
        return patientService.getPatientById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * Endpoint to add a new patient.
     * Accepts a Patient object in the request body and saves it.
     * @param patient
     * @return
     */
    @PostMapping
    public ResponseEntity<?> addPatient(@RequestBody Patient patient) {
        return ResponseEntity.ok(patientService.savePatient(patient));
    }

    /**
     *Endpoint to update an existing patient's details.
     *Accepts the patient ID in the URL path and a Patient object with updated details in the request body.
     * @param id
     * @param patient
     * @return
     */
    @PutMapping("/{id}")
    public ResponseEntity<?> updatePatient(@PathVariable Long id, @RequestBody Patient patient) {
        return ResponseEntity.ok(patientService.updatePatient(id, patient));
    }
}
