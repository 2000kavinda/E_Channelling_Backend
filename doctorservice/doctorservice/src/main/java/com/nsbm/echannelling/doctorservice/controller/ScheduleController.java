package com.nsbm.echannelling.doctorservice.controller;

import com.nsbm.echannelling.doctorservice.model.Schedule;
import com.nsbm.echannelling.doctorservice.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.*;

@RestController
@RequestMapping("/schedule")
public class ScheduleController {

    @Autowired
    private ScheduleService scheduleService;

    public String saveSchedule(@RequestBody Schedule schedule){
        scheduleService.saveSchedule(schedule);
        return "Successfully Saved!";
    }
}
