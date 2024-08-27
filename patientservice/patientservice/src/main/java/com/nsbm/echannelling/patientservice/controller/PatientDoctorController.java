package com.nsbm.echannelling.patientservice.controller;

import com.nsbm.echannelling.patientservice.model.PatientDoctor;
import com.nsbm.echannelling.patientservice.service.implementation.PatientDoctorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
    @RequestMapping("/api/doctors")
    public class PatientDoctorController {
    /**
     * Injects the PatientDoctorServiceImpl into the controller
     */
        @Autowired
        private PatientDoctorServiceImpl patient_doctorService;

    /**
     * Endpoint to add a new doctor.
     * Accepts a PatientDoctor object in the request body and saves it.
     * @param patient_doctor
     * @return
     */
        @PostMapping("/add")
        public String add(@RequestBody PatientDoctor patient_doctor){
           patient_doctorService.save(patient_doctor);
            return "New Doctor Added";
        }

    /**
     *request ApI for the get all list of doctors
     * @return
     */
        @GetMapping("/getAll")
        public List<PatientDoctor> Lists(){
            return patient_doctorService.ListAll();
    }

    /**
     * Endpoint to search for doctors by name, specialty, or type.
     * All parameters are optional; if no parameters are provided, all doctors will be returned.
     * @param name
     * @param specialty
     * @param type
     * @return
     */
    @GetMapping("/search")
    public List<PatientDoctor> searchDoctorsByType(@RequestParam(required = false) String name,
                                                   @RequestParam(required = false) String specialty,
                                                   @RequestParam(required = false) String type) {
        return patient_doctorService.searchDoctorsByFilters(name, specialty, type);
    }


    }
