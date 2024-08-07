package com.nsbm.echannelling.patientservice.service;

import com.nsbm.echannelling.patientservice.model.DoctorDetails_Temp;
import com.nsbm.echannelling.patientservice.repository.DoctorDetails_TempRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DoctorDetails_Service {

    @Autowired
    private DoctorDetails_TempRepo doctordetails_temprepo;

    public List<DoctorDetails_Temp> getAllDoctorDetails() {
        return doctordetails_temprepo.findAll();
    }

    public DoctorDetails_Temp getDoctorDetailsByRegNo(Long doctorRegNo) {
        return doctordetails_temprepo.findByDoctorRegNo(doctorRegNo);
    }

    public DoctorDetails_Temp saveDoctorDetails(DoctorDetails_Temp doctorDetails) {
        return doctordetails_temprepo.save(doctorDetails);
    }
}
