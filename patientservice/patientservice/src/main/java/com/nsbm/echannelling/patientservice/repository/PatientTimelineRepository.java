package com.nsbm.echannelling.patientservice.repository;

import com.nsbm.echannelling.patientservice.model.PatientTimeline;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PatientTimelineRepository extends JpaRepository<PatientTimeline, Long> {
    List<PatientTimeline> findByPatientId(Long patientId);

}
