package com.nsbm.echannelling.notificationservice.service.implementation;



import com.nsbm.echannelling.notificationservice.model.Notification;
import com.nsbm.echannelling.notificationservice.repository.NotificationRepository;
import com.nsbm.echannelling.notificationservice.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationServiceImpl implements NotificationService
{

    @Autowired
    private NotificationRepository notificationRepository;

    /**
     * @param notification
     * @return
     */
    @Override
    public Notification saveNotification(Notification notification) {
        return notificationRepository.save(notification);  // Save and return the Notification
    }

    /**
     *
     * @param nId
     * @return
     */
    @Override
    public String deleteNotification(Long nId) {
        notificationRepository.deleteById(nId);
        return "Notification deleted Successfully";
    }

    /**
     *
     * @return
     */
    @Override
    public List<Notification> getAllNotifications() {

        return notificationRepository.findAll();
    }
@Override
    public Notification getNotificationById(Long nId) {

        return notificationRepository.findById(nId).get();
    }
    @Override
    public List<Notification> getNotificationsByPatientCode(String patientCode) {
        return notificationRepository.findByPatientCode(patientCode);
    }
    @Override
    public String markNotificationAsRead(Long nId, String patientCode) {
        Notification notification = notificationRepository.findById(nId).orElse(null);
        if (notification != null && notification.getPatientCode().equals(patientCode)) {
            notification.setRead(true);
            notificationRepository.save(notification);
            return "Notification marked as read";
        }
        return "Notification not found or invalid patient code";
    }


}