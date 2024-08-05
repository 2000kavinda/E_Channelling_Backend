package com.nsbm.echannelling.authenticationservice.repository;

import com.nsbm.echannelling.authenticationservice.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}
