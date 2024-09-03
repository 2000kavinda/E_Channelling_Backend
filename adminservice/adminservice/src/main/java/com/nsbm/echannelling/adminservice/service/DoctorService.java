package com.nsbm.echannelling.adminservice.service;

import com.nsbm.echannelling.adminservice.model.Doctor;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface DoctorService {
    ResponseEntity<?> getDoctorCount();

    ResponseEntity<?> getAllDoctors();

    ResponseEntity<?>  updateDoctor(Long drRegNo, Doctor newDoctor);

    ResponseEntity<?>  deleteDoctor(Long drRegNo);

    ResponseEntity<?> searchDoctorByName(String name);
}
