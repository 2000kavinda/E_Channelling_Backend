package com.nsbm.echannelling.patientservice.repository;

import com.nsbm.echannelling.patientservice.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepo extends JpaRepository<Patient, Long> {
}
