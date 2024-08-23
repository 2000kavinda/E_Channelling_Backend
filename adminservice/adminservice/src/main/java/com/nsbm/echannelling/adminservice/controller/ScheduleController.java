package com.nsbm.echannelling.adminservice.controller;

import com.nsbm.echannelling.adminservice.dto.ScheduleDTO;
import com.nsbm.echannelling.adminservice.model.Schedule;
import com.nsbm.echannelling.adminservice.service.implementation.ScheduleServiceImpl;
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

    /**
     * save a schedule
     * @param schedule
     * @return
     */
    @PostMapping("save")
    public String saveSchedules(@RequestBody Schedule schedule) {
        return scheduleService.saveSchedule(schedule);
    }

    /**
     * retriview all schedules
     * @return
     */
    @GetMapping("/all")
    public ResponseEntity<?> getAllSchedulesWithDoctorName() {
        return scheduleService.getAllSchedules();

    }

    /**
     * search schedule by the date
     * @param date
     * @return
     */
    @GetMapping("/search")
    public ResponseEntity<?> searchSchedulesWithDoctorName(@RequestParam LocalDate date) {
        return scheduleService.searchScheduleWithId(date);

    }

    /**
     * update the existing selected schedule
     * @param id
     * @param schedule
     * @return
     */
    @PutMapping("/update")
    public ResponseEntity<?> updateSchedule(@RequestParam Long id,@RequestBody Schedule schedule) {
        return scheduleService.updateSchedule(id,schedule);

    }

    /**
     * delete selected schedule
     * @param id
     * @return
     */
    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteSchedule(@RequestParam Long id) {
        return scheduleService.deleteSchedule(id);

    }

    /**
     * search schedule by DR. name
     * @param drNamePart
     * @return
     */
    @GetMapping("/searchN")
    public ResponseEntity<?> getSchedulesByDoctorNamePart(@RequestParam String drNamePart) {
        return ResponseEntity.ok(scheduleService.getSchedulesByDoctorNamePart(drNamePart));
    }
}
