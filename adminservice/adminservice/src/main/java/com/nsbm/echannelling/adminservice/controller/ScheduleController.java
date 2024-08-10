package com.nsbm.echannelling.adminservice.controller;

import com.nsbm.echannelling.adminservice.dto.ScheduleDTO;
import com.nsbm.echannelling.adminservice.model.Schedule;
import com.nsbm.echannelling.adminservice.service.ScheduleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("api/v1/schedule")
public class ScheduleController {

    @Autowired
    ScheduleServiceImpl scheduleService;



    @PostMapping("save")
    public String saveSchedules(@RequestBody Schedule schedule) {
        return scheduleService.saveSchedule(schedule);
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllSchedulesWithDoctorName() {
        return scheduleService.getAllSchedules();

    }

    /*@GetMapping("/search")
    public ResponseEntity<?> searchSchedulesWithDoctorName(@RequestParam LocalDate date) {
        return scheduleService.searchScheduleWithId(date);

    }*/

    @PutMapping("/update")
    public ResponseEntity<?> updateSchedule(@RequestParam Long id,@RequestBody Schedule schedule) {
        return scheduleService.updateSchedule(id,schedule);

    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteSchedule(@RequestParam Long id) {
        return scheduleService.deleteSchedule(id);

    }

    @GetMapping("/searchN")
    public ResponseEntity<List<ScheduleDTO>> getSchedulesByDoctorNamePart(@RequestParam String drNamePart) {
        List<ScheduleDTO> schedules = scheduleService.getSchedulesByDoctorNamePart(drNamePart);
        return ResponseEntity.ok(schedules);
    }
}
