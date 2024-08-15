package com.nsbm.echannelling.patientservice.service;

import com.nsbm.echannelling.patientservice.model.PatientTimeline;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PatientTimelineService {
    ResponseEntity<?> saveTimeLine(Long patientId, PatientTimeline patient_timeline);

    List<PatientTimeline> getTimelinesByPatientId(Long patientId);

    ResponseEntity<?> updateTimeLine(Long patientId, Long timelineId, PatientTimeline updatedTimeline);
}
