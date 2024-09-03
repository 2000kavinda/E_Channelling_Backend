package com.nsbm.echannelling.doctorservice.controller;

import com.nsbm.echannelling.doctorservice.model.Schedule;
import com.nsbm.echannelling.doctorservice.service.implementation.ScheduleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@CrossOrigin("*")
@RestController
@RequestMapping("api/v1/schedule")
public class ScheduleController {
    @Autowired
    private ScheduleServiceImpl scheduleService;

    /**
     * get all schedules for the DR
     * @param drRegNo
     * @return
     */
    @GetMapping("/filter")
    public ResponseEntity<?> getAllSchedules(@RequestParam Long drRegNo) {
        return scheduleService.filterSchedules(drRegNo);

    }

    /**
     * save DR schedule
     * @param schedule
     * @return
     */
    @PostMapping("/save")
    public String saveSchedules(@RequestBody Schedule schedule) {
        return scheduleService.saveSchedule(schedule);
    }

    /**
     * update own schedule
     * @param id
     * @param schedule
     * @return
     */
    @PutMapping("/update")
    public ResponseEntity<?> updateSchedule(@RequestParam Long id,@RequestBody Schedule schedule) {
        return scheduleService.updateSchedule(id,schedule);

    }

    /**
     * delete own schedule
     * @param id
     * @return
     */
    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteSchedule(@RequestParam Long id) {
        return scheduleService.deleteSchedule(id);

    }

    /**
     * DR's total channeling time
     * @param drRegNo
     * @param date
     * @return
     */
    @GetMapping("/totaltime")
    public ResponseEntity<?> getTotalTime(@RequestParam Long drRegNo, @RequestParam LocalDate date) {
       // long totalTime = ;
        return ResponseEntity.ok(scheduleService.getTotalTime(drRegNo, date));
    }

    /**
     * DR's total room count
     * @param date
     * @param drRegNo
     * @return
     */
    @GetMapping("/totalroomcount")
    public ResponseEntity<?> getRoomCount(@RequestParam LocalDate date, @RequestParam Long drRegNo) {
       // Long roomCount = ;
        return ResponseEntity.ok(scheduleService.getTotalRoomCount(date, drRegNo));
    }

}
