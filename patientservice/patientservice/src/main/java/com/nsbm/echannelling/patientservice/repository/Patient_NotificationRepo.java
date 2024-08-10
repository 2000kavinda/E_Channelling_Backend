package com.nsbm.echannelling.patientservice.repository;

import com.nsbm.echannelling.patientservice.model.Patient_Notification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Patient_NotificationRepo extends JpaRepository<Patient_Notification, Long> {


    List<Patient_Notification> findByDoctorId(Long doctorId);
    List<Patient_Notification> findByDoctorIdAndIsRead(Long doctorId, boolean isRead);
    List<Patient_Notification> findByDoctorIdAndIsFavorite(Long doctorId, boolean isFavorite);
}
