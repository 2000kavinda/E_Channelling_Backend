package com.nsbm.echannelling.adminservice.controller;

import com.nsbm.echannelling.adminservice.dto.ScheduleDTO;
import com.nsbm.echannelling.adminservice.model.Schedule;
import com.nsbm.echannelling.adminservice.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/schedule")
public class ScheduleController {

    @Autowired
    ScheduleService scheduleService;



    @PostMapping("save")
    public String saveSchedules(@RequestBody Schedule schedule) {
        return scheduleService.saveSchedule(schedule);
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllSchedulesWithDoctorName() {
        return scheduleService.getAllSchedules();

    }
}
