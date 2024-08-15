package com.nsbm.echannelling.patientservice.service;

import com.nsbm.echannelling.patientservice.model.PatientDoctor;

import java.util.List;
import java.util.Optional;

public interface PatientDoctorService {
    // temorary add the doctors
    List<PatientDoctor> ListAll();

    void save(PatientDoctor patient_doctor);

    //this is for the Get Doctors List --->first endpoint
    List<PatientDoctor> getAllDoctors();

    //this is for the filter doctors by using types --->second endpoint
    List<PatientDoctor> searchDoctorsByFilters(String name, String specialty, String type);

    Optional<PatientDoctor> getDoctorById(Long doctorId);
}
