package com.nsbm.echannelling.adminservice.service;

import com.nsbm.echannelling.adminservice.dto.ScheduleDTO;
import com.nsbm.echannelling.adminservice.model.Schedule;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.List;

public interface ScheduleService {
    String saveSchedule(Schedule schedule);

    ResponseEntity<?>  getAllSchedules();

    ResponseEntity<?>  searchScheduleWithId(LocalDate date);

    ResponseEntity<?>  updateSchedule(Long sId, Schedule newSchedule);

    ResponseEntity<?> deleteSchedule(Long sId);

    List<ScheduleDTO> getSchedulesByDoctorNamePart(String drNamePart);
}
