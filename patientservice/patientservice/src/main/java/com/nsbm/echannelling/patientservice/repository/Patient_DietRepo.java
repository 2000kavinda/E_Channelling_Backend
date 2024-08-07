package com.nsbm.echannelling.patientservice.repository;

import com.nsbm.echannelling.patientservice.model.Patient_Diet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface Patient_DietRepo extends JpaRepository<Patient_Diet, Long> {
    Optional<Patient_Diet> findByPatientId(Long patientId);
}
