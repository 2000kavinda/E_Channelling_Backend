package com.nsbm.echannelling.patientservice.service;

import com.nsbm.echannelling.patientservice.model.Patient_Timeline;
import com.nsbm.echannelling.patientservice.repository.Patient_Timeline_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Patient_Timeline_Service {

    @Autowired
    private Patient_Timeline_Repository patient_timeline_repository;

    public ResponseEntity<?> saveTimeLine(Long patientId, Patient_Timeline patient_timeline) {
        try {
            patient_timeline.setPatientId(patientId);
            return  ResponseEntity.ok(patient_timeline_repository.save(patient_timeline));

        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Something went wrong");
        }
    }

    public List<Patient_Timeline> getTimelinesByPatientId(Long patientId) {
        return patient_timeline_repository.findByPatientId(patientId);
    }

    public ResponseEntity<?> updateTimeLine(Long patientId, Long timelineId, Patient_Timeline updatedTimeline) {
        try {
            Optional<Patient_Timeline> existingTimeline = patient_timeline_repository.findById(timelineId);

            if (existingTimeline.isPresent() && existingTimeline.get().getPatientId().equals(patientId)) {
                Patient_Timeline timeline = existingTimeline.get();
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
