package com.nsbm.echannelling.patientservice.controller;

import com.nsbm.echannelling.patientservice.model.PatientTimeline;
import com.nsbm.echannelling.patientservice.service.implementation.PatientTimelineServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/api/timeline")
public class PatientTimelineController {

    //Injects the PatientTimelineServiceImpl into the controller
    @Autowired
    private PatientTimelineServiceImpl patient_timeline_service;

    /**
     *Endpoint to save a new timeline entry for a specific patient.
     * @param patientId
     * @param patient_timeline
     * @return
     */
    @PostMapping("/save/{patientId}")
    public ResponseEntity<?> saveSchedules(@PathVariable Long patientId, @RequestBody PatientTimeline patient_timeline) {
        return patient_timeline_service.saveTimeLine(patientId,patient_timeline);
    }

    /**
     * Endpoint to retrieve timeline entries for a specific patient by their ID.
     * @param patientId
     * @return
     */
    @GetMapping("/search")
    public ResponseEntity<List<PatientTimeline>> getTimelinesByPatientId(@RequestParam Long patientId) {
        List<PatientTimeline> timelines = patient_timeline_service.getTimelinesByPatientId(patientId);
        return ResponseEntity.ok(timelines);
    }

    /**
     * Endpoint to update a specific timeline entry for a patient.
     * Accepts the patient ID and timeline ID in the URL path, and a PatientTimeline object with updated details in the request body.
     * @param patientId
     * @param timelineId
     * @param updatedTimeline
     * @return
     */
    @PutMapping("/update/{patientId}/{timelineId}")
    public ResponseEntity<?> updateTimeline(
            @PathVariable Long patientId,
            @PathVariable Long timelineId,
            @RequestBody PatientTimeline updatedTimeline) {
        return patient_timeline_service.updateTimeLine(patientId, timelineId, updatedTimeline);
    }


}
