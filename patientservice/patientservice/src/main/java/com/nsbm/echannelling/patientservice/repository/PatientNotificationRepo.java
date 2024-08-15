package com.nsbm.echannelling.patientservice.repository;

import com.nsbm.echannelling.patientservice.model.PatientNotification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PatientNotificationRepo extends JpaRepository<PatientNotification, Long> {


    List<PatientNotification> findByDoctorId(Long doctorId);
    List<PatientNotification> findByDoctorIdAndIsRead(Long doctorId, boolean isRead);
    List<PatientNotification> findByDoctorIdAndIsFavorite(Long doctorId, boolean isFavorite);
}
