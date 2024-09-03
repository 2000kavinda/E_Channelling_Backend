package com.nsbm.echannelling.patientservice.service;

import com.nsbm.echannelling.patientservice.model.PatientDoctor;
import com.nsbm.echannelling.patientservice.model.ScheduleTemp;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface ScheduleService {
    List<ScheduleTemp> getSchedulesByDoctorId(Long drRegNo);

    //Add temporary schedules
    ResponseEntity<?> addSchedule(ScheduleTemp scheduleTemp);

    //get relevent dates for each specific doctor
    List<LocalDate> getBookingDatesByDoctorId(Long drRegNo);

    //get doctor registration id
    Optional<PatientDoctor> getDoctorById(Long doctorId);
}
