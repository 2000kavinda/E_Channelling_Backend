package com.nsbm.echannelling.patientservice.repository;

import com.nsbm.echannelling.patientservice.model.DoctorDetailsTemp;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorDetailsTempRepo extends JpaRepository<DoctorDetailsTemp, Long> {
    // Custom query method to find a doctor by their registration number
    DoctorDetailsTemp findByDoctorRegNo(Long doctorRegNo);
}
