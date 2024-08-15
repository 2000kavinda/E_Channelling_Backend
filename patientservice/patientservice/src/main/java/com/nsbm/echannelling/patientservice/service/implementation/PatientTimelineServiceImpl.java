package com.nsbm.echannelling.patientservice.service.implementation;

import com.nsbm.echannelling.patientservice.model.PatientTimeline;
import com.nsbm.echannelling.patientservice.repository.PatientTimelineRepository;
import com.nsbm.echannelling.patientservice.service.PatientTimelineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientTimelineServiceImpl implements PatientTimelineService {

    @Autowired
    private PatientTimelineRepository patient_timeline_repository;
@Override
    public ResponseEntity<?> saveTimeLine(Long patientId, PatientTimeline patient_timeline) {
        try {
            patient_timeline.setPatientId(patientId);
            return  ResponseEntity.ok(patient_timeline_repository.save(patient_timeline));

        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Something went wrong");
        }
    }
    @Override
    public List<PatientTimeline> getTimelinesByPatientId(Long patientId) {
        return patient_timeline_repository.findByPatientId(patientId);
    }
    @Override
    public ResponseEntity<?> updateTimeLine(Long patientId, Long timelineId, PatientTimeline updatedTimeline) {
        try {
            Optional<PatientTimeline> existingTimeline = patient_timeline_repository.findById(timelineId);

            if (existingTimeline.isPresent() && existingTimeline.get().getPatientId().equals(patientId)) {
                PatientTimeline timeline = existingTimeline.get();
                timeline.setDate(updatedTimeline.getDate());
                timeline.setType(updatedTimeline.getType());
                timeline.setOther(updatedTimeline.getOther());

                return ResponseEntity.ok(patient_timeline_repository.save(timeline));
            } else {
                return ResponseEntity.badRequest().body("Timeline not found or does not belong to the specified patient");
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Something went wrong: " + e.getMessage());
        }
    }


}
