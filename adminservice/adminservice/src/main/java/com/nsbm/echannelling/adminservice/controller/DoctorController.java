package com.nsbm.echannelling.adminservice.controller;

import com.nsbm.echannelling.adminservice.model.Doctor;
import com.nsbm.echannelling.adminservice.service.DoctorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/doctor")
public class DoctorController {

    @Autowired
    private DoctorServiceImpl doctorService;

    @GetMapping("/count")
    public ResponseEntity<?> getDoctorCount() {
        return ResponseEntity.ok(doctorService.getDoctorCount());
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllDoctor() {
        return doctorService.getAllDoctors();

    }

    @PutMapping("/update")
    public ResponseEntity<?> updateDoctor(@RequestParam Long drRegNo, @RequestBody Doctor doctor) {
        return doctorService.updateDoctor(drRegNo,doctor);

    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteDoctor(@RequestParam Long drRegNo) {
        return doctorService.deleteDoctor(drRegNo);

    }

    @GetMapping("/search")
    public ResponseEntity<List<Doctor>> searchLabPersonByName(@RequestParam String name) {
        List<Doctor> doctor = doctorService.searchDoctorByName(name);
        return ResponseEntity.ok(doctor);
    }

}
