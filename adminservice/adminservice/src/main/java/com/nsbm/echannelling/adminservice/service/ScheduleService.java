package com.nsbm.echannelling.adminservice.service;

import com.nsbm.echannelling.adminservice.dto.ScheduleDTO;
import com.nsbm.echannelling.adminservice.model.Schedule;
import com.nsbm.echannelling.adminservice.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class ScheduleService {

    @Autowired
    private ScheduleRepository scheduleRepository;

    public String saveSchedule(Schedule schedule) {
        try {
            scheduleRepository.save(schedule);
            return "Schedule saved";
        } catch (Exception e) {
            return  e.getMessage();
        }
    }



    public ResponseEntity<?>  getAllSchedules() {
        try {
            return  ResponseEntity.ok(scheduleRepository.findAllSchedulesWithDrName());

        } catch (Exception e) {

            return ResponseEntity.badRequest().body("Something went wrong");
        }
    }


}
