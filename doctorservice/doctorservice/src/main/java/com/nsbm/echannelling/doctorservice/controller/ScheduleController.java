package com.nsbm.echannelling.doctorservice.controller;

import com.nsbm.echannelling.doctorservice.model.Schedule;
import com.nsbm.echannelling.doctorservice.service.ScheduleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/schedules")
public class ScheduleController {
    @Autowired
    private ScheduleServiceImpl scheduleService;

    @GetMapping("/filter")
    public ResponseEntity<?> getAllSchedules(@RequestParam Long drRegNo) {
        return scheduleService.filterSchedules(drRegNo);

    }

    @PostMapping("/save")
    public String saveSchedules(@RequestBody Schedule schedule) {
        return scheduleService.saveSchedule(schedule);
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateSchedule(@RequestParam Long id,@RequestBody Schedule schedule) {
        return scheduleService.updateSchedule(id,schedule);

    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteSchedule(@RequestParam Long id) {
        return scheduleService.deleteSchedule(id);

    }


}
