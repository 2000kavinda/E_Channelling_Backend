package com.nsbm.echannelling.patientservice.repository;

import com.nsbm.echannelling.patientservice.model.DoctorDetailsTemp;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorDetailsTempRepo extends JpaRepository<DoctorDetailsTemp, Long> {
    DoctorDetailsTemp findByDoctorRegNo(Long doctorRegNo);
}
