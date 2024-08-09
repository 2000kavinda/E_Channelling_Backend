package com.nsbm.echannelling.adminservice.controller;

import com.nsbm.echannelling.adminservice.model.Patient;
import com.nsbm.echannelling.adminservice.model.Schedule;
import com.nsbm.echannelling.adminservice.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/patient")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @GetMapping("/all")
    public ResponseEntity<?> getAllPatients() {
        return patientService.getAllPatients();

    }

    @PutMapping("/update")
    public ResponseEntity<?> updatePatient(@RequestParam Long pId, @RequestBody Patient patient) {
        return patientService.updatePatient(pId,patient);

    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deletePatient(@RequestParam Long pId) {
        return patientService.deletePatient(pId);

    }

    @GetMapping("/search")
    public ResponseEntity<List<Patient>> searchPatientsByName(@RequestParam String name) {
        List<Patient> patients = patientService.searchPatientsByName(name);
        return ResponseEntity.ok(patients);
    }
}
