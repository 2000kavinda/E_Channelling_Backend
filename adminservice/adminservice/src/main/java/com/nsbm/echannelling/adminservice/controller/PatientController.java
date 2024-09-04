package com.nsbm.echannelling.adminservice.controller;

import com.nsbm.echannelling.adminservice.model.Patient;
import com.nsbm.echannelling.adminservice.service.implementation.PatientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("api/v1/patient")
public class PatientController {

    @Autowired
    private PatientServiceImpl patientService;

    // get all patients
    @GetMapping("/all")
    public ResponseEntity<?> getAllPatients() {
        return patientService.getAllPatients();

    }

    @GetMapping("/getpatientdata")
    public ResponseEntity<?> getAPatient(@RequestParam Long pId) {
        return patientService.getAPatient(pId);

    }

    /**
     * update existing selected patient
     * @param pId
     * @param patient
     * @return
     */
    @PutMapping("/update")
    public ResponseEntity<?> updatePatient(@RequestParam Long pId, @RequestBody Patient patient) {
        return patientService.updatePatient(pId,patient);

    }

    /**
     * delete selected patient
     * @param pId
     * @return
     */
    @DeleteMapping("/delete")
    public ResponseEntity<?> deletePatient(@RequestParam Long pId) {
        return patientService.deletePatient(pId);

    }

    /**
     * search existing patients by the name
     * @param name
     * @return
     */
    @GetMapping("/search")
    public ResponseEntity<?> searchPatientsByName(@RequestParam String name) {
        return ResponseEntity.ok(patientService.searchPatientsByName(name));
    }
}
