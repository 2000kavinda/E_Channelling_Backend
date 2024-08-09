package com.nsbm.echannelling.patientservice.controller;

import com.nsbm.echannelling.patientservice.model.Patient_Timeline;
import com.nsbm.echannelling.patientservice.service.Patient_Timeline_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/timeline")
public class Patient_Timeline_Controller {

    @Autowired
    private Patient_Timeline_Service patient_timeline_service;

    @PostMapping("/save/{patientId}")
    public ResponseEntity<?> saveSchedules(@PathVariable Long patientId, @RequestBody Patient_Timeline patient_timeline) {
        return patient_timeline_service.saveTimeLine(patientId,patient_timeline);
    }

    @GetMapping("/search")

    public ResponseEntity<List<Patient_Timeline>> getTimelinesByPatientId(@RequestParam Long patientId) {
        List<Patient_Timeline> timelines = patient_timeline_service.getTimelinesByPatientId(patientId);
        return ResponseEntity.ok(timelines);
    }
    @PutMapping("/update/{patientId}/{timelineId}")
    public ResponseEntity<?> updateTimeline(
            @PathVariable Long patientId,
            @PathVariable Long timelineId,
            @RequestBody Patient_Timeline updatedTimeline) {
        return patient_timeline_service.updateTimeLine(patientId, timelineId, updatedTimeline);
    }


}
