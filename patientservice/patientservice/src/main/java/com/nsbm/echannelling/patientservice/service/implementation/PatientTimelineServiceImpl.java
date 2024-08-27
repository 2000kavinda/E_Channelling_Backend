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

    /**
     *inserts the repository dependency for PatientTimeline
     */
    @Autowired
    private PatientTimelineRepository patient_timeline_repository;
    /**
     * Saves a new timeline for a specific patient
     * @param patientId
     * @param patient_timeline
     * @return
     */

    @Override
    public ResponseEntity<?> saveTimeLine(Long patientId, PatientTimeline patient_timeline) {
        try {
            patient_timeline.setPatientId(patientId);
            return  ResponseEntity.ok(patient_timeline_repository.save(patient_timeline));

        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Something went wrong");
        }
    }

    /**
     *Retrieves all timelines for a specific patient by filtering from patientId
     * @param patientId
     * @return
     */
    @Override
    public List<PatientTimeline> getTimelinesByPatientId(Long patientId) {
        return patient_timeline_repository.findByPatientId(patientId);
    }

    /**
     *Updates an existing timeline for a specific patient
     * @param patientId
     * @param timelineId
     * @param updatedTimeline
     * @return
     */
    @Override
    public ResponseEntity<?> updateTimeLine(Long patientId, Long timelineId, PatientTimeline updatedTimeline) {
        try {
            Optional<PatientTimeline> existingTimeline = patient_timeline_repository.findById(timelineId);

            // Checks if the timeline exists and belongs to the specified patient
            if (existingTimeline.isPresent() && existingTimeline.get().getPatientId().equals(patientId)) {
                PatientTimeline timeline = existingTimeline.get();
                // Updates the fields of the existing timeline
                timeline.setDate(updatedTimeline.getDate());
                timeline.setType(updatedTimeline.getType());
                timeline.setOther(updatedTimeline.getOther());

                return ResponseEntity.ok(patient_timeline_repository.save(timeline));
            } else {
                return ResponseEntity.badRequest().body("Timeline not found or does not belong to the specified patient");
            }
        } catch (Exception e) {
            // Handles any exceptions and returns a bad request response with the error message
            return ResponseEntity.badRequest().body("Something went wrong: " + e.getMessage());
        }
    }


}
