package com.nsbm.echannelling.patientservice.controller;

import com.nsbm.echannelling.patientservice.model.PatientNotification;
import com.nsbm.echannelling.patientservice.service.implementation.PatientNotificationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/api/notifications")
public class PatientNotificationController {

    /**
     * Injects the PatientNotificationServiceImpl into the controller
     */
    @Autowired
    private PatientNotificationServiceImpl notificationService;

    /**
     * Endpoint to add a new notification for a specific doctor.
     *Accepts a PatientNotification object in the request body and the doctorId as a path variable.
     * @param doctorId
     * @param notification
     * @return
     */
    @PostMapping("/add/{doctorId}")
    public ResponseEntity<?> addNotification(@PathVariable Long doctorId, @RequestBody PatientNotification notification) {
        return notificationService.addNotification(doctorId, notification);
    }

    /**
     * Endpoint to retrieve notifications for a specific doctor by their ID.
     * @param doctorId
     * @return
     */
    @GetMapping("/view/{doctorId}")
    public ResponseEntity<List<PatientNotification>> getNotificationsByDoctorId(@PathVariable Long doctorId) {
        List<PatientNotification> notifications = notificationService.getNotificationsByDoctorId(doctorId);
        return ResponseEntity.ok(notifications);
    }

    /**
     * Endpoint to delete a specific notification by its ID.
     * @param notificationId
     * @return
     */

    @DeleteMapping("/delete/{notificationId}")
    public ResponseEntity<?> deleteNotification(@PathVariable Long notificationId) {
        return notificationService.deleteNotification(notificationId);
    }

    /**
     * Endpoint to mark a specific notification as read by its ID.
     * @param notificationId
     * @return
     */
    @PutMapping("/markAsRead/{notificationId}")
    public ResponseEntity<?> markAsRead(@PathVariable Long notificationId) {
        return notificationService.markAsRead(notificationId);
    }

    /**
     *  Endpoint to mark a specific notification as favorite by its ID.
     * @param notificationId
     * @return
     */
    @PutMapping("/markAsFavorite/{notificationId}")
    public ResponseEntity<?> markAsFavorite(@PathVariable Long notificationId) {
        return notificationService.markAsFavorite(notificationId);
    }
}
