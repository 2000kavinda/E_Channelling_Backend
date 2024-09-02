package com.nsbm.echannelling.adminservice.repository;

import com.nsbm.echannelling.adminservice.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}
