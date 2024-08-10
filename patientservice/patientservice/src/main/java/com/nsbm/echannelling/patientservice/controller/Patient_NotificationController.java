package com.nsbm.echannelling.patientservice.controller;

import com.nsbm.echannelling.patientservice.model.Patient_Notification;
import com.nsbm.echannelling.patientservice.service.Patient_NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/notifications")
public class Patient_NotificationController {

    @Autowired
    private Patient_NotificationService notificationService;

    @PostMapping("/add/{doctorId}")
    public ResponseEntity<?> addNotification(@PathVariable Long doctorId, @RequestBody Patient_Notification notification) {
        return notificationService.addNotification(doctorId, notification);
    }

    @GetMapping("/view/{doctorId}")
    public ResponseEntity<List<Patient_Notification>> getNotificationsByDoctorId(@PathVariable Long doctorId) {
        List<Patient_Notification> notifications = notificationService.getNotificationsByDoctorId(doctorId);
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
