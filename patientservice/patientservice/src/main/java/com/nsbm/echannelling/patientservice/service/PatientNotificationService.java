package com.nsbm.echannelling.patientservice.service;

import com.nsbm.echannelling.patientservice.model.PatientNotification;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PatientNotificationService {
    ResponseEntity<?> addNotification(Long doctorId, PatientNotification notification);

    List<PatientNotification> getNotificationsByDoctorId(Long doctorId);

    ResponseEntity<?> deleteNotification(Long notificationId);

    ResponseEntity<?> markAsRead(Long notificationId);

    ResponseEntity<?> markAsFavorite(Long notificationId);
}
