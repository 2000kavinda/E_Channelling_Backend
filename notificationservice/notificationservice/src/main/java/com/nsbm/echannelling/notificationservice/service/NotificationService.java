package com.nsbm.echannelling.notificationservice.service;

import com.nsbm.echannelling.notificationservice.model.Notification;

import java.util.List;

public interface NotificationService {
    Notification saveNotification(Notification notification);

    String deleteNotification(Long nId);

    List<Notification> getAllNotifications();

    Notification getNotificationById(Long nId);

    List<Notification> getNotificationsByPatientCode(String patientCode);

    String markNotificationAsRead(Long nId, String patientCode);
}
