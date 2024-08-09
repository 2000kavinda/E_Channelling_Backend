package com.nsbm.echannelling.doctorservice.repository;

import com.nsbm.echannelling.doctorservice.model.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ScheduleRepository extends JpaRepository <Schedule,Long> {
//    Optional<Schedule> findByDrID(long drRegNo);
List<Schedule> findByDrRegNo(Long drRegNo);


}
