package com.nsbm.echannelling.patientservice.service.implementation;

import com.nsbm.echannelling.patientservice.model.PatientNotification;
import com.nsbm.echannelling.patientservice.repository.PatientNotificationRepo;
import com.nsbm.echannelling.patientservice.service.PatientNotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
//remove underscore from classname**********
//Add comments
//Add doc comments
//Add impl package move all *******

// Add exceptions

//****ResponseEntity<?>
//return ResponseEntity.ok(count);
//catch (Exception e) {
//       return ResponseEntity.badRequest().body("Something went wrong: " + e.getMessage());
//      }




import java.util.List;
import java.util.Optional;

@Service
public class PatientNotificationServiceImpl implements PatientNotificationService {

    @Autowired
    private PatientNotificationRepo notificationRepository;

    //  Add new notification in patient side
    @Override
    public ResponseEntity<?> addNotification(Long doctorId, PatientNotification notification) {
        try {

            notification.setDoctorId(doctorId);
            notification.setDate(new java.text.SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date()));
            notification.setRead(false);  // New notifications are unread by default
            return ResponseEntity.ok(notificationRepository.save(notification));
        } catch (Exception e) {
            // add exception handling
            return ResponseEntity.badRequest().body("Something went wrong: " + e.getMessage());
        }
    }

    // Retrieves all notifications
    @Override
    public List<PatientNotification> getNotificationsByDoctorId(Long doctorId) {
        return notificationRepository.findByDoctorId(doctorId);
    }

    //delete the specific notification from its ID
    @Override
    public ResponseEntity<?> deleteNotification(Long notificationId) {
        try {
            notificationRepository.deleteById(notificationId);
            return ResponseEntity.ok("Notification deleted successfully.");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Something went wrong: " + e.getMessage());
        }
    }

    // Marks a notification as read by its ID
    @Override
    public ResponseEntity<?> markAsRead(Long notificationId) {
        try {
            Optional<PatientNotification> notification = notificationRepository.findById(notificationId);
            if (notification.isPresent()) {
                PatientNotification notif = notification.get();
                notif.setRead(true);
                return ResponseEntity.ok(notificationRepository.save(notif));
            } else {
                return ResponseEntity.badRequest().body("Notification not found.");
            }
        } catch (Exception e) {
            // Handles any exceptions and returns a bad request response with the error message
            return ResponseEntity.badRequest().body("Something went wrong: " + e.getMessage());
        }
    }

    // Marks a notification as a favorite by its ID
    @Override
    public ResponseEntity<?> markAsFavorite(Long notificationId) {
        try {
            Optional<PatientNotification> notification = notificationRepository.findById(notificationId);
            if (notification.isPresent()) {
                PatientNotification notif = notification.get();
                notif.setFavorite(true);
                return ResponseEntity.ok(notificationRepository.save(notif));
            } else {
                return ResponseEntity.badRequest().body("Notification not found.");
            }
        } catch (Exception e) {
            // Handles any exceptions and returns a bad request response with the error message
            return ResponseEntity.badRequest().body("Something went wrong: " + e.getMessage());
        }
    }
}
