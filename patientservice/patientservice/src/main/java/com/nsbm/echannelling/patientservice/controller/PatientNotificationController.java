package com.nsbm.echannelling.patientservice.controller;

import com.nsbm.echannelling.patientservice.model.PatientNotification;
import com.nsbm.echannelling.patientservice.service.implementation.PatientNotificationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/notifications")
public class PatientNotificationController {

    @Autowired
    private PatientNotificationServiceImpl notificationService;

    @PostMapping("/add/{doctorId}")
    public ResponseEntity<?> addNotification(@PathVariable Long doctorId, @RequestBody PatientNotification notification) {
        return notificationService.addNotification(doctorId, notification);
    }

    @GetMapping("/view/{doctorId}")
    public ResponseEntity<List<PatientNotification>> getNotificationsByDoctorId(@PathVariable Long doctorId) {
        List<PatientNotification> notifications = notificationService.getNotificationsByDoctorId(doctorId);
        return ResponseEntity.ok(notifications);
    }

    @DeleteMapping("/delete/{notificationId}")
    public ResponseEntity<?> deleteNotification(@PathVariable Long notificationId) {
        return notificationService.deleteNotification(notificationId);
    }

    @PutMapping("/markAsRead/{notificationId}")
    public ResponseEntity<?> markAsRead(@PathVariable Long notificationId) {
        return notificationService.markAsRead(notificationId);
    }

    @PutMapping("/markAsFavorite/{notificationId}")
    public ResponseEntity<?> markAsFavorite(@PathVariable Long notificationId) {
        return notificationService.markAsFavorite(notificationId);
    }
}
