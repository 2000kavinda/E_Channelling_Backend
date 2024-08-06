package com.nsbm.echannelling.patientservice.service;

import com.nsbm.echannelling.patientservice.model.Patient_Doctor;
import com.nsbm.echannelling.patientservice.repository.Patient_DoctorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Patient_DoctorService {

    @Autowired
    private Patient_DoctorRepo patient_doctorRepo;

    // temorary add the doctors
    public List<Patient_Doctor> ListAll() {
        return patient_doctorRepo.findAll();
    }
    public void save(Patient_Doctor patient_doctor) {
        patient_doctorRepo.save(patient_doctor);
    }

    // from this point that endpoints are started in my side


    //this is for the Get Doctors List --->first endpoint
    public List<Patient_Doctor> getAllDoctors() {
        return patient_doctorRepo.findAll();
    }

    //this is for the filter doctors by using types --->second endpoint
    public List<Patient_Doctor> searchDoctorsByFilters(String name, String specialty, String type) {
        return patient_doctorRepo.searchDoctorsByFilter(name, specialty, type);
    }

    public Optional<Patient_Doctor> getDoctorById(Long doctorId) {
        return patient_doctorRepo.findById(doctorId);
    }
}

