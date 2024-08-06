package com.nsbm.echannelling.doctorservice.repository;

import com.nsbm.echannelling.doctorservice.model.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository <Schedule,Long> {


}
