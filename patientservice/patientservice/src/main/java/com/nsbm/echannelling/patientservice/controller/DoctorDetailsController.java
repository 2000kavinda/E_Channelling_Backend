package com.nsbm.echannelling.patientservice.controller;

import com.nsbm.echannelling.patientservice.model.DoctorDetailsTemp;
import com.nsbm.echannelling.patientservice.service.implementation.DoctorDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/doctor-details")
public class DoctorDetailsController {

    /**
     * Insert the DoctorDetailsServiceImpl to manage doctor details-related operations
     */
    @Autowired
    private DoctorDetailsServiceImpl doctorDetailsService;

    /**
     * Endpoint to retrieve list of  all doctor details
     * @return
     */
    @GetMapping("/all")
    public ResponseEntity<?> getAllDoctorDetails() {
        return doctorDetailsService.getAllDoctorDetails();
    }

    /**
     * Endpoint to retrieve doctor details by their registration number(RegNo)
     * @param doctorRegNo
     * @return
     */
    @GetMapping("/{doctorRegNo}")
    public ResponseEntity<DoctorDetailsTemp> getDoctorDetailsByRegNo(@PathVariable Long doctorRegNo) {
        DoctorDetailsTemp doctorDetails = doctorDetailsService.getDoctorDetailsByRegNo(doctorRegNo);
        if (doctorDetails != null) {
            return ResponseEntity.ok(doctorDetails);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Endpoint to add new doctor details
     * @param doctorDetails
     * @return
     */
    @PostMapping("/add")
    public ResponseEntity<String> addDoctorDetails(@RequestBody DoctorDetailsTemp doctorDetails) {
        DoctorDetailsTemp savedDoctorDetails = doctorDetailsService.saveDoctorDetails(doctorDetails);

        if (savedDoctorDetails != null) {
            return ResponseEntity.ok("Doctor details added successfully.");
        } else {
            return ResponseEntity.status(500).body("Failed to add doctor details.");
        }
    }

}
