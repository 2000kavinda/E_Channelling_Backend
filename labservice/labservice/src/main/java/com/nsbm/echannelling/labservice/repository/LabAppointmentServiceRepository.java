package com.nsbm.echannelling.labservice.repository;

import com.nsbm.echannelling.labservice.model.LabAppointmentModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LabAppointmentServiceRepository extends JpaRepository<LabAppointmentModel, Long> {
}
