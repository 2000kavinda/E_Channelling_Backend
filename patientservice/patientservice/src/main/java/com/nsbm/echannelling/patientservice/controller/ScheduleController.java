package com.nsbm.echannelling.patientservice.controller;

import com.nsbm.echannelling.patientservice.model.ScheduleModel;
import com.nsbm.echannelling.patientservice.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/schedules")
public class ScheduleController {

    @Autowired
    private ScheduleService scheduleService;

    @PostMapping("/add")
    public ScheduleModel addSchedule(@RequestBody ScheduleModel schedule) {
        return scheduleService.addSchedule(schedule);
    }
}
