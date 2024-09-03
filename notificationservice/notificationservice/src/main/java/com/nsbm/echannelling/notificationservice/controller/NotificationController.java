package com.nsbm.echannelling.notificationservice.controller;

import com.nsbm.echannelling.notificationservice.model.Notification;
import com.nsbm.echannelling.notificationservice.service.implementation.NotificationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/notification")
public class NotificationController {

    @Autowired
    private NotificationServiceImpl notificationService;

    /**
     * Create a new notification.
     *
     * @param notification the notification to create
     * @return a ResponseEntity with the location of the created resource
     */
    @PostMapping
    public ResponseEntity<Void> saveNotification(@RequestBody Notification notification) {
        Notification savedNotification = notificationService.saveNotification(notification);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedNotification.getNId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    /**
     * Update an existing notification.
     *
     * @param id the ID of the notification to update
     * @param notification the updated notification data
     * @return the updated notification
     */
    @PutMapping("/{id}")
    public ResponseEntity<Notification> updateNotification(@PathVariable Long id, @RequestBody Notification notification) {
        notification.setNId(id);
        Notification updatedNotification = notificationService.saveNotification(notification);
        return ResponseEntity.ok(updatedNotification);
    }

    /**
     * Delete a notification by ID.
     *
     * @param id the ID of the notification to delete
     * @return a ResponseEntity with a success message
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteNotification(@PathVariable Long id) {
        String result = notificationService.deleteNotification(id);
        return ResponseEntity.ok(result);
    }

    /**
     * List all notifications.
     *
     * @return a list of all notifications
     */
    @GetMapping
    public ResponseEntity<List<Notification>> viewAllNotifications() {
        List<Notification> notifications = notificationService.getAllNotifications();
        return ResponseEntity.ok(notifications);
    }

    /**
     * View a specific notification by ID.
     *
     * @param id the ID of the notification to view
     * @return the requested notification
     */
    @GetMapping("/{id}")
    public ResponseEntity<Notification> viewNotification(@PathVariable Long id) {
        Notification notification = notificationService.getNotificationById(id);
        if (notification == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(notification);
    }

    /**
     * List notifications filtered by patient code.
     *
     * @param patientCode the patient code to filter by
     * @return a list of notifications associated with the given patient code
     */
    @GetMapping("/patient")
    public ResponseEntity<List<Notification>> getNotificationsByPatientCode(@RequestParam String patientCode) {
        List<Notification> notifications = notificationService.getNotificationsByPatientCode(patientCode);
        return ResponseEntity.ok(notifications);
    }

    /**
     * Delete a specific notification for a patient, using the patient code as a filter.
     *
     * @param id the ID of the notification to delete
     * @param patientCode the patient code to verify permission
     * @return a ResponseEntity with a success message
     */
    @DeleteMapping("/{id}/patient")
    public ResponseEntity<String> deleteNotificationForPatient(@PathVariable Long id, @RequestParam String patientCode) {
        Notification notification = notificationService.getNotificationById(id);
        if (notification != null && notification.getPatientCode().equals(patientCode)) {
            String result = notificationService.deleteNotification(id);
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.status(403).body("Notification not found or invalid patient code");
    }

    /**
     * Mark a specific notification as read for a patient.
     *
     * @param id the ID of the notification to mark as read
     * @param patientCode the patient code to verify permission
     * @return a ResponseEntity with a success message
     */
    @PutMapping("/{id}/markAsRead")
    public ResponseEntity<String> markNotificationAsRead(@PathVariable Long id, @RequestParam String patientCode) {
        String result = notificationService.markNotificationAsRead(id, patientCode);
        if (result != null) {
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.status(403).body("Notification not found or invalid patient code");
    }
}
