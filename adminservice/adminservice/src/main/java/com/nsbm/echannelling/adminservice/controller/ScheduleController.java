package com.nsbm.echannelling.adminservice.controller;

import com.nsbm.echannelling.adminservice.dto.ScheduleDTO;
import com.nsbm.echannelling.adminservice.model.Schedule;
import com.nsbm.echannelling.adminservice.repository.ScheduleRepository;
import com.nsbm.echannelling.adminservice.service.implementation.ScheduleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("api/v1/schedule")
public class ScheduleController {

    @Autowired
    ScheduleServiceImpl scheduleService;

    @Autowired
    private ScheduleRepository scheduleRepository;

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

    /**
     * get full data view for selected schedule id
     * @param sId
     * @return
     */
    @GetMapping("/{sId}")
    public ResponseEntity<ScheduleDTO> getScheduleBySId(@PathVariable Long sId) {
        return scheduleRepository.findScheduleBySId(sId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
