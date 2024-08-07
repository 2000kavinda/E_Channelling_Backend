package com.nsbm.echannelling.patientservice.repository;

import com.nsbm.echannelling.patientservice.model.DoctorDetails_Temp;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DoctorDetails_TempRepo extends JpaRepository<DoctorDetails_Temp, Long> {
    DoctorDetails_Temp findByDoctorRegNo(Long doctorRegNo);
}
