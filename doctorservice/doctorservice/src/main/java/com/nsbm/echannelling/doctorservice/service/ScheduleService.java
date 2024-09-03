package com.nsbm.echannelling.doctorservice.service;

import com.nsbm.echannelling.doctorservice.model.Schedule;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;

public interface ScheduleService {
    ResponseEntity<?> filterSchedules(Long drRegNo);

    String saveSchedule(Schedule schedule);

    ResponseEntity<?>  updateSchedule(Long sId, Schedule newSchedule);

    ResponseEntity<?>  deleteSchedule(Long sId);

    ResponseEntity<?> getTotalTime(Long drRegNo, LocalDate date);

    ResponseEntity<?> getTotalRoomCount(LocalDate date, Long drRegNo);
}
