package com.nsbm.echannelling.patientservice.service;

import com.nsbm.echannelling.patientservice.model.DoctorDetails_Temp;

import java.util.List;

public interface DoctorDetails_Service {
    List<DoctorDetails_Temp> getAllDoctorDetails();

    DoctorDetails_Temp getDoctorDetailsByRegNo(Long doctorRegNo);

    DoctorDetails_Temp saveDoctorDetails(DoctorDetails_Temp doctorDetails);
}
