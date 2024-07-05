package com.nsbm.echannelling.doctorservice.controller;

import com.nsbm.echannelling.doctorservice.model.Doctor;
import com.nsbm.echannelling.doctorservice.service.DoctorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @PostMapping("/add")
    public String add(@RequestBody Doctor doctor) {
        try {
            if (doctorService.existsByDrRegNo(doctor.getDrRegNo())) {
                return "Doctor with registration number " + doctor.getDrRegNo() + " already exists";
            }
            doctorService.save(doctor);
            return "success";
        } catch (Exception e) {
            return e.toString();
        }
    }

    @GetMapping("/getAll")
    public List<Doctor> list() {
        return doctorService.listAll();
    }

   /* @GetMapping("/search")
    public ResponseEntity<?> search(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String type,
            @RequestParam(required = false) String specialty) {

        List<Doctor> doctors = doctorService.findByCriteria(name, type, specialty);

        if (doctors.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No doctors found with the specified criteria");
        } else {
            return ResponseEntity.ok(doctors);
        }
    }*/

    @GetMapping("/search")
    public ResponseEntity<?> search(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String type,
            @RequestParam(required = false) String specialty) {

        List<Doctor> doctors = doctorService.findByCriteria(name, type, specialty);

        if (doctors.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No doctors found with the specified criteria");
        } else {
            return ResponseEntity.ok(doctors);
        }
    }

}
