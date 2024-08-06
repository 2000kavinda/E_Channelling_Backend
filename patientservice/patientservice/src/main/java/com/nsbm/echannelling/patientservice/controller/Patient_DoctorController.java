package com.nsbm.echannelling.patientservice.controller;

import com.nsbm.echannelling.patientservice.model.Patient_Doctor;
import com.nsbm.echannelling.patientservice.service.Patient_DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
    @RequestMapping("/api/doctors")
    public class Patient_DoctorController {
        @Autowired
        private Patient_DoctorService patient_doctorService;


        @PostMapping("/add")
        public String add(@RequestBody Patient_Doctor patient_doctor){
           patient_doctorService.save(patient_doctor);
            return "New Doctor Added";
        }

        //request ApI for the get all list of doctors
        @GetMapping("/getAll")
        public List<Patient_Doctor> Lists(){
            return patient_doctorService.ListAll();
    }
    @GetMapping("/search")
    public List<Patient_Doctor> searchDoctorsByType(@RequestParam(required = false) String name,
                                                    @RequestParam(required = false) String specialty,
                                                    @RequestParam(required = false) String type) {
        return patient_doctorService.searchDoctorsByFilters(name, specialty, type);
    }


    }
