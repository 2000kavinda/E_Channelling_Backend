package com.nsbm.echannelling.patientservice.controller;

import com.nsbm.echannelling.patientservice.model.PatientTimeline;
import com.nsbm.echannelling.patientservice.service.implementation.PatientTimelineServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/timeline")
public class PatientTimelineController {

    @Autowired
    private PatientTimelineServiceImpl patient_timeline_service;

    @PostMapping("/save/{patientId}")
    public ResponseEntity<?> saveSchedules(@PathVariable Long patientId, @RequestBody PatientTimeline patient_timeline) {
        return patient_timeline_service.saveTimeLine(patientId,patient_timeline);
    }

    @GetMapping("/search")

    public ResponseEntity<List<PatientTimeline>> getTimelinesByPatientId(@RequestParam Long patientId) {
        List<PatientTimeline> timelines = patient_timeline_service.getTimelinesByPatientId(patientId);
        return ResponseEntity.ok(timelines);
    }
    @PutMapping("/update/{patientId}/{timelineId}")
    public ResponseEntity<?> updateTimeline(
            @PathVariable Long patientId,
            @PathVariable Long timelineId,
            @RequestBody PatientTimeline updatedTimeline) {
        return patient_timeline_service.updateTimeLine(patientId, timelineId, updatedTimeline);
    }


}
