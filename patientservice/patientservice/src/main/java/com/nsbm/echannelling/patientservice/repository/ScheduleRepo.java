package com.nsbm.echannelling.patientservice.repository;

import com.nsbm.echannelling.patientservice.model.ScheduleModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScheduleRepo extends JpaRepository<ScheduleModel, Long> {

    List<ScheduleModel> findByDrRegNo(Long drRegNo);
}
