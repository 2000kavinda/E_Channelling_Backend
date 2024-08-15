package com.nsbm.echannelling.patientservice.repository;

import com.nsbm.echannelling.patientservice.model.ScheduleTemp;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScheduleRepo extends JpaRepository<ScheduleTemp, Long> {
    List<ScheduleTemp> findByDrRegNo(Long drRegNo);
}
