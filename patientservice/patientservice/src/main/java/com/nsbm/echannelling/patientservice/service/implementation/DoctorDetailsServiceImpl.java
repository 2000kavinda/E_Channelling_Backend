package com.nsbm.echannelling.patientservice.service.implementation;

import com.nsbm.echannelling.patientservice.model.DoctorDetailsTemp;
import com.nsbm.echannelling.patientservice.repository.DoctorDetailsTempRepo;
import com.nsbm.echannelling.patientservice.service.DoctorDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DoctorDetailsServiceImpl implements DoctorDetailsService {

    @Autowired
    private DoctorDetailsTempRepo doctordetails_temprepo;

    @Override
    public ResponseEntity<?> getAllDoctorDetails() {
try
        {
            return ResponseEntity.ok( doctordetails_temprepo.findAll());

        }
 catch (Exception e) {
    return ResponseEntity.badRequest().body("Something went wrong: " + e.getMessage());
 }
    }

    @Override
    public DoctorDetailsTemp getDoctorDetailsByRegNo(Long doctorRegNo) {
        return doctordetails_temprepo.findByDoctorRegNo(doctorRegNo);
    }

    @Override
    public DoctorDetailsTemp saveDoctorDetails(DoctorDetailsTemp doctorDetails) {
        return doctordetails_temprepo.save(doctorDetails);
    }
}
