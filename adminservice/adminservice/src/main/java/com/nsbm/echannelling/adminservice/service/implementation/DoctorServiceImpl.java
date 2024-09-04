package com.nsbm.echannelling.adminservice.service.implementation;

import com.nsbm.echannelling.adminservice.model.Doctor;
import com.nsbm.echannelling.adminservice.repository.CredentialsRepository;
import com.nsbm.echannelling.adminservice.repository.DoctorRepository;
import com.nsbm.echannelling.adminservice.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private CredentialsRepository credentialsRepository;

    //view total count of doctors available
    @Override
    public ResponseEntity<?> getDoctorCount() {
        try {
            long count = doctorRepository.count();
            return ResponseEntity.ok(count);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    //view details of all doctors available
    @Override
    public ResponseEntity<?> getAllDoctors() {
        try {
            return  ResponseEntity.ok(doctorRepository.findAll());

        }catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    /**
     * get the all details of specific selected DR
     * @param drRegNo
     * @return
     */
    @Override
    public ResponseEntity<?> getADoctor(Long drRegNo) {
        try {
            return  ResponseEntity.ok(doctorRepository.findById(drRegNo));

        }catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    /**
     * update existing selected doctor details
     * @param drRegNo
     * @param newDoctor
     * @return
     */
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

    /**
     * delete existing doctor details from doctor and credential DBs
     * @param drRegNo
     * @return
     */
    @Override
    public ResponseEntity<?>  deleteDoctor(Long drRegNo) {
        try {
            Optional<Doctor> credentialOptional = doctorRepository.findById(drRegNo);
            if (credentialOptional.isPresent())
            {
                doctorRepository.deleteById(drRegNo);
                credentialsRepository.deleteById(drRegNo);

                return ResponseEntity.ok("Doctor deleted successfully");
            }else {
                return ResponseEntity.ok("Doctor not found");
            }

        } catch (Exception e) {

            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    /**
     * search DR. by typing the name
     * @param name
     * @return
     */
    @Override
    public ResponseEntity<?> searchDoctorByName(String name) {
       try {
            return ResponseEntity.ok(doctorRepository.findByNameContaining(name));
        }catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
