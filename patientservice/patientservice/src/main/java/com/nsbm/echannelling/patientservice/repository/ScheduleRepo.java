package com.nsbm.echannelling.patientservice.repository;

import com.nsbm.echannelling.patientservice.model.ScheduleTemp;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScheduleRepo extends JpaRepository<ScheduleTemp, Long> {
    // Finds a list of ScheduleTemp associated with drRegNo
    List<ScheduleTemp> findByDrRegNo(Long drRegNo);
}
