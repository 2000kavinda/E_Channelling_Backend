package com.nsbm.echannelling.notificationservice.repository;


import com.nsbm.echannelling.notificationservice.model.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NotificationRepository extends JpaRepository<Notification, Long> {

    List<Notification> findByPatientCode(String patientCode);

}