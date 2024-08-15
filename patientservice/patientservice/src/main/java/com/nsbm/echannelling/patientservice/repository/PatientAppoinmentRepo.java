package com.nsbm.echannelling.patientservice.repository;

import com.nsbm.echannelling.patientservice.model.PatientAppoinment;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PatientAppoinmentRepo extends JpaRepository<PatientAppoinment, Long> {

}
