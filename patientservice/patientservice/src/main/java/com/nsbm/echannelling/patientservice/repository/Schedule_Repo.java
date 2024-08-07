package com.nsbm.echannelling.patientservice.repository;

import com.nsbm.echannelling.patientservice.model.Schedule_Temp;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.util.List;

public interface Schedule_Repo  extends JpaRepository<Schedule_Temp, Long> {
    List<Schedule_Temp> findByDrRegNo(Long drRegNo);
}
