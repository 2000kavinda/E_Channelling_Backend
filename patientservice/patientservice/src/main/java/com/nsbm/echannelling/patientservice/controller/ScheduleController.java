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
@RequestMapping("/api/schedules")
public class ScheduleController {

    @Autowired
    private ScheduleServiceImpl scheduleTempService;
    @Autowired
    private PatientDoctorServiceImpl patient_DoctorService;

    // Endpoint to add a new schedule
    @PostMapping
    public ScheduleTemp addSchedule(@RequestBody ScheduleTemp scheduleTemp) {
        return scheduleTempService.addSchedule(scheduleTemp);
    }

    // Endpoint to get schedules details by doctor ID
    @GetMapping("/{doctorId}")
    public List<ScheduleTemp> getSchedulesByDoctorId(@PathVariable Long doctorId) {
        return scheduleTempService.getSchedulesByDoctorId(doctorId);
    }

    @GetMapping("/{doctorId}/dates")
    public List<LocalDate> getBookingDatesByDoctorId(@PathVariable Long doctorId) {
        return scheduleTempService.getBookingDatesByDoctorId(doctorId);
    }

    // Endpoint to retrieve doctor ID by doctor ID
    @GetMapping("/info/{doctorId}")
    public ResponseEntity<Long> getDoctorIdById(@PathVariable Long doctorId) {
        Optional<PatientDoctor> doctor = patient_DoctorService.getDoctorById(doctorId);
        return doctor.map(d -> ResponseEntity.ok(d.getDrRegNo()))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
