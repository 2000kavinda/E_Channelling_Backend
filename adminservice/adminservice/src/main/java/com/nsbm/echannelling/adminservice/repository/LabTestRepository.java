package com.nsbm.echannelling.adminservice.repository;

import com.nsbm.echannelling.adminservice.model.Appointment;
import com.nsbm.echannelling.adminservice.model.LabTest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LabTestRepository extends JpaRepository<LabTest, Long> {
}
