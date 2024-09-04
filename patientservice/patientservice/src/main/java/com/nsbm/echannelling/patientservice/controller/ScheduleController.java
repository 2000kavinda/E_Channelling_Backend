package com.nsbm.echannelling.patientservice.controller;

import com.nsbm.echannelling.patientservice.model.PatientDoctor;
import com.nsbm.echannelling.patientservice.model.ScheduleTemp;
import com.nsbm.echannelling.patientservice.service.implementation.PatientDoctorServiceImpl;
import com.nsbm.echannelling.patientservice.service.implementation.ScheduleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/api/schedules")
public class ScheduleController {

    /**
     * Injects the ScheduleServiceImpl into the controller
     */
    @Autowired
    private ScheduleServiceImpl scheduleTempService;
    /**
     * Injects the PatientDoctorServiceImpl into the controller
     */
    @Autowired
    private PatientDoctorServiceImpl patient_DoctorService;

    /**
     * Endpoint to add a new schedule.
     * @param scheduleTemp
     * @return
     */
    @PostMapping
    public ResponseEntity<?> addSchedule(@RequestBody ScheduleTemp scheduleTemp) {
        return scheduleTempService.addSchedule(scheduleTemp);
    }

    /**
     * Endpoint to get schedules details by doctor ID
     * @param doctorId
     * @return
     */
    @GetMapping("/{doctorId}")
    public List<ScheduleTemp> getSchedulesByDoctorId(@PathVariable Long doctorId) {
        return scheduleTempService.getSchedulesByDoctorId(doctorId);
    }

    /**
     *Endpoint to retrieve available booking dates by doctor ID.
     * @param doctorId
     * @return
     */
    @GetMapping("/{doctorId}/dates")
    public List<LocalDate> getBookingDatesByDoctorId(@PathVariable Long doctorId) {
        return scheduleTempService.getBookingDatesByDoctorId(doctorId);
    }

    /**
     * Endpoint to retrieve doctor ID by doctor ID
     * @param doctorId
     * @return
     */
    @GetMapping("/info/{doctorId}")
    public ResponseEntity<Long> getDoctorIdById(@PathVariable Long doctorId) {
        Optional<PatientDoctor> doctor = patient_DoctorService.getDoctorById(doctorId);
        return doctor.map(d -> ResponseEntity.ok(d.getDrRegNo()))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
