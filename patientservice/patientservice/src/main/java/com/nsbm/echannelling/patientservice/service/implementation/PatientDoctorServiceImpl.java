package com.nsbm.echannelling.patientservice.service.implementation;

import com.nsbm.echannelling.patientservice.model.PatientDoctor;
import com.nsbm.echannelling.patientservice.repository.PatientDoctorRepo;
import com.nsbm.echannelling.patientservice.service.PatientDoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientDoctorServiceImpl implements PatientDoctorService {

    @Autowired
    private PatientDoctorRepo patient_doctorRepo;

    // temorary add the doctors
    @Override
    public List<PatientDoctor> ListAll() {
        return patient_doctorRepo.findAll();
    }
    @Override
    public void save(PatientDoctor patient_doctor) {
        patient_doctorRepo.save(patient_doctor);
    }

    // from this point that endpoints are started in my side


    //this is for the Get Doctors List --->first endpoint
    @Override
    public List<PatientDoctor> getAllDoctors() {
        return patient_doctorRepo.findAll();
    }

    //this is for the filter doctors by using types --->second endpoint
    @Override
    public List<PatientDoctor> searchDoctorsByFilters(String name, String specialty, String type) {
        return patient_doctorRepo.searchDoctorsByFilter(name, specialty, type);
    }

    //this is for the filter doctors by using DoctorId
    @Override
    public Optional<PatientDoctor> getDoctorById(Long doctorId) {
        return patient_doctorRepo.findById(doctorId);
    }
}

