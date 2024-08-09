package com.nsbm.echannelling.patientservice.repository;

import com.nsbm.echannelling.patientservice.model.Patient_Timeline;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Patient_Timeline_Repository extends JpaRepository<Patient_Timeline, Long> {
    List<Patient_Timeline> findByPatientId(Long patientId);

}
