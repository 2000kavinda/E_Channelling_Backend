package com.nsbm.echannelling.adminservice.service;

import com.nsbm.echannelling.adminservice.model.Doctor;
import com.nsbm.echannelling.adminservice.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorServiceImpl implements DoctorService{

    @Autowired
    private DoctorRepository doctorRepository;

    @Override
    public ResponseEntity<?> getDoctorCount() {
        try {
            long count = doctorRepository.count();
            return ResponseEntity.ok(count);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Something went wrong");
        }
    }

    @Override
    public ResponseEntity<?> getAllDoctors() {
        try {
            return  ResponseEntity.ok(doctorRepository.findAll());

        } catch (Exception e) {

            return ResponseEntity.badRequest().body("Something went wrong");
        }
    }

    @Override
    public ResponseEntity<?>  updateDoctor(Long drRegNo, Doctor newDoctor) {
        try {
            Optional<Doctor> credentialOptional = doctorRepository.findById(drRegNo);
            Doctor doctor = credentialOptional.get();
            doctor.setDrName(newDoctor.getDrName());
            doctor.setSpecialize(newDoctor.getSpecialize());
            doctor.setType(newDoctor.getType());
            doctor.setProfileImage(newDoctor.getProfileImage());
            doctor.setDrQualification(newDoctor.getDrQualification());


            return  ResponseEntity.ok(doctorRepository.save(doctor));

        } catch (Exception e) {

            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @Override
    public ResponseEntity<?>  deleteDoctor(Long drRegNo) {
        try {
            Optional<Doctor> credentialOptional = doctorRepository.findById(drRegNo);
            if (credentialOptional.isPresent())
            {
                doctorRepository.deleteById(drRegNo);

                return ResponseEntity.ok("Doctor deleted successfully");
            }else {
                return ResponseEntity.ok("Doctor not found");
            }

        } catch (Exception e) {

            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @Override
    public List<Doctor> searchDoctorByName(String name) {
        return doctorRepository.findByNameContaining(name);
    }

}
