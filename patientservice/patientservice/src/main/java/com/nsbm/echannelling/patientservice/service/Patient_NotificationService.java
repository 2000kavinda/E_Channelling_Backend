package com.nsbm.echannelling.patientservice.service;

import com.nsbm.echannelling.patientservice.model.Patient_Notification;
import com.nsbm.echannelling.patientservice.repository.Patient_NotificationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Patient_NotificationService {

    @Autowired
    private Patient_NotificationRepo notificationRepository;

    public ResponseEntity<?> addNotification(Long doctorId, Patient_Notification notification) {
        try {
            notification.setDoctorId(doctorId);
            notification.setDate(new java.text.SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date()));
            notification.setRead(false);  // New notifications are unread by default
            return ResponseEntity.ok(notificationRepository.save(notification));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Something went wrong: " + e.getMessage());
        }
    }

    public List<Patient_Notification> getNotificationsByDoctorId(Long doctorId) {
        return notificationRepository.findByDoctorId(doctorId);
    }

    public ResponseEntity<?> deleteNotification(Long notificationId) {
        try {
            notificationRepository.deleteById(notificationId);
            return ResponseEntity.ok("Notification deleted successfully.");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Something went wrong: " + e.getMessage());
        }
    }

    public ResponseEntity<?> markAsRead(Long notificationId) {
        try {
            Optional<Patient_Notification> notification = notificationRepository.findById(notificationId);
            if (notification.isPresent()) {
                Patient_Notification notif = notification.get();
                notif.setRead(true);
                return ResponseEntity.ok(notificationRepository.save(notif));
            } else {
                return ResponseEntity.badRequest().body("Notification not found.");
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Something went wrong: " + e.getMessage());
        }
    }

    public ResponseEntity<?> markAsFavorite(Long notificationId) {
        try {
            Optional<Patient_Notification> notification = notificationRepository.findById(notificationId);
            if (notification.isPresent()) {
                Patient_Notification notif = notification.get();
                notif.setFavorite(true);
                return ResponseEntity.ok(notificationRepository.save(notif));
            } else {
                return ResponseEntity.badRequest().body("Notification not found.");
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Something went wrong: " + e.getMessage());
        }
    }
}
