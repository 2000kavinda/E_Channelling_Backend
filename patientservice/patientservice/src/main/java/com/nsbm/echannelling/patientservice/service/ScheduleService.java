package com.nsbm.echannelling.patientservice.service;

import com.nsbm.echannelling.patientservice.model.Patient_Doctor;
import com.nsbm.echannelling.patientservice.model.Schedule_Temp;
import com.nsbm.echannelling.patientservice.repository.Patient_DoctorRepo;
import com.nsbm.echannelling.patientservice.repository.Schedule_Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ScheduleService {
    @Autowired
    private Schedule_Repo schedule_repo ;
    @Autowired
    private Patient_DoctorRepo patient_DoctorRepo;

    public List<Schedule_Temp> getSchedulesByDoctorId(Long drRegNo) {
        return schedule_repo.findByDrRegNo(drRegNo);
    }

    //Add temporary schedules
    public Schedule_Temp addSchedule(Schedule_Temp scheduleTemp) {
        return schedule_repo.save(scheduleTemp);
    }

    //get relevent dates for each specific doctor
    public List<LocalDate> getBookingDatesByDoctorId(Long drRegNo) {
        List<Schedule_Temp> schedules = schedule_repo.findByDrRegNo(drRegNo);
        return schedules.stream()
                .map(Schedule_Temp::getDate)
                .collect(Collectors.toList());
    }

    //get doctor registration id
    public Optional<Patient_Doctor> getDoctorById(Long doctorId) {
        return patient_DoctorRepo.findById(doctorId);
    }




}
