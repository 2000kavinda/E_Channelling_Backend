package com.nsbm.echannelling.patientservice.repository;

import com.nsbm.echannelling.patientservice.model.Patient_MedicalHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface Patient_MedicalHistoryRepo extends JpaRepository<Patient_MedicalHistory, Long> {

    Optional<Patient_MedicalHistory> findByPatientId(Long patientId);
}