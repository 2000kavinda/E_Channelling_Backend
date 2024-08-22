package com.nsbm.echannelling.patientservice.repository;

import com.nsbm.echannelling.patientservice.model.PatientNotification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PatientNotificationRepo extends JpaRepository<PatientNotification, Long> {


    // Finds all notifications associated with doctorId
    List<PatientNotification> findByDoctorId(Long doctorId);

    // Finds all notifications with specific read status
    List<PatientNotification> findByDoctorIdAndIsRead(Long doctorId, boolean isRead);

    // Finds all notifications with a  specific favorite status
    List<PatientNotification> findByDoctorIdAndIsFavorite(Long doctorId, boolean isFavorite);
}
