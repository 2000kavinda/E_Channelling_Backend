package com.nsbm.echannelling.patientservice.repository;

import com.nsbm.echannelling.patientservice.model.Patient_Medications;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Patient_MedicationsRepo extends JpaRepository<Patient_Medications, Long> {

    List<Patient_Medications> findByPatientId(Long patientId);
}
