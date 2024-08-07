package com.nsbm.echannelling.patientservice.controller;

import com.nsbm.echannelling.patientservice.model.Patient_Doctor;
import com.nsbm.echannelling.patientservice.model.Schedule_Temp;
import com.nsbm.echannelling.patientservice.service.Patient_DoctorService;
import com.nsbm.echannelling.patientservice.service.ScheduleService;
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
    private ScheduleService scheduleTempService;
    @Autowired
    private Patient_DoctorService patient_DoctorService;

    // Endpoint to add a new schedule
    @PostMapping
    public Schedule_Temp addSchedule(@RequestBody Schedule_Temp scheduleTemp) {
        return scheduleTempService.addSchedule(scheduleTemp);
    }

    // Endpoint to get schedules details by doctor ID
    @GetMapping("/{doctorId}")
    public List<Schedule_Temp> getSchedulesByDoctorId(@PathVariable Long doctorId) {
        return scheduleTempService.getSchedulesByDoctorId(doctorId);
    }

    @GetMapping("/{doctorId}/dates")
    public List<LocalDate> getBookingDatesByDoctorId(@PathVariable Long doctorId) {
        return scheduleTempService.getBookingDatesByDoctorId(doctorId);
    }

    // Endpoint to retrieve doctor ID by doctor ID
    @GetMapping("/info/{doctorId}")
    public ResponseEntity<Long> getDoctorIdById(@PathVariable Long doctorId) {
        Optional<Patient_Doctor> doctor = patient_DoctorService.getDoctorById(doctorId);
        return doctor.map(d -> ResponseEntity.ok(d.getDrRegNo()))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
