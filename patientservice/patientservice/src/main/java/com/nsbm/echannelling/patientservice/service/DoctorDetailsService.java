package com.nsbm.echannelling.patientservice.service;

import com.nsbm.echannelling.patientservice.model.DoctorDetailsTemp;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface DoctorDetailsService {
    ResponseEntity<?> getAllDoctorDetails();

    ResponseEntity<?> getDoctorDetailsByRegNo(Long doctorRegNo);

    ResponseEntity<?> saveDoctorDetails(DoctorDetailsTemp doctorDetails);
}
