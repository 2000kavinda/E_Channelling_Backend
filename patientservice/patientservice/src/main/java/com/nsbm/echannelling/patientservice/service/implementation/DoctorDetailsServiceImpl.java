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

    // Adds the DoctorDetailsTemp repository requirement.
    @Autowired
    private DoctorDetailsTempRepo doctordetails_temprepo;

    // Retrieves all doctor details from the database
    @Override
    public ResponseEntity<?> getAllDoctorDetails() {
try
        {
            // Retrieves all records of the DoctorDetailsTemp table
            return ResponseEntity.ok( doctordetails_temprepo.findAll());

        }
 catch (Exception e) {

    //Handles the exceptions
    return ResponseEntity.badRequest().body("Something went wrong: " + e.getMessage());
 }
    }

    // Retrieves doctor details by  filtering their registration number
    @Override
    public DoctorDetailsTemp getDoctorDetailsByRegNo(Long doctorRegNo) {
        return doctordetails_temprepo.findByDoctorRegNo(doctorRegNo);
    }

    // Saves doctor details within the db
    @Override
    public DoctorDetailsTemp saveDoctorDetails(DoctorDetailsTemp doctorDetails) {
        return doctordetails_temprepo.save(doctorDetails);
    }
}
