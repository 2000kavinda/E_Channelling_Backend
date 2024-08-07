package com.nsbm.echannelling.patientservice.controller;

import com.nsbm.echannelling.patientservice.model.DoctorDetails_Temp;
import com.nsbm.echannelling.patientservice.service.DoctorDetails_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/doctor-details")
public class DoctorDetails_Controller {


    @Autowired
    private DoctorDetails_Service doctorDetailsService;

    @GetMapping("/all")
    public List<DoctorDetails_Temp> getAllDoctorDetails() {
        return doctorDetailsService.getAllDoctorDetails();
    }

    @GetMapping("/{doctorRegNo}")
    public ResponseEntity<DoctorDetails_Temp> getDoctorDetailsByRegNo(@PathVariable Long doctorRegNo) {
        DoctorDetails_Temp doctorDetails = doctorDetailsService.getDoctorDetailsByRegNo(doctorRegNo);
        if (doctorDetails != null) {
            return ResponseEntity.ok(doctorDetails);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/add")
    public ResponseEntity<String> addDoctorDetails(@RequestBody DoctorDetails_Temp doctorDetails) {
        DoctorDetails_Temp savedDoctorDetails = doctorDetailsService.saveDoctorDetails(doctorDetails);

        if (savedDoctorDetails != null) {
            return ResponseEntity.ok("Doctor details added successfully.");
        } else {
            return ResponseEntity.status(500).body("Failed to add doctor details.");
        }
    }

}
