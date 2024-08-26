package com.nsbm.echannelling.patientservice.service.implementation;

import com.nsbm.echannelling.patientservice.model.PatientDoctor;
import com.nsbm.echannelling.patientservice.model.ScheduleTemp;
import com.nsbm.echannelling.patientservice.repository.PatientDoctorRepo;
import com.nsbm.echannelling.patientservice.repository.ScheduleRepo;
import com.nsbm.echannelling.patientservice.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ScheduleServiceImpl implements ScheduleService {
    @Autowired
    private ScheduleRepo schedule_repo ;
    @Autowired
    private PatientDoctorRepo patient_DoctorRepo;

    /**
     * get schedule lists from doctor id
     * @param drRegNo
     * @return
     */
    @Override
    public List<ScheduleTemp> getSchedulesByDoctorId(Long drRegNo) {
        return schedule_repo.findByDrRegNo(drRegNo);
    }

    /**
     *Add temporary schedules
     * @param scheduleTemp
     * @return
     */
    @Override
    public ScheduleTemp addSchedule(ScheduleTemp scheduleTemp) {
        return schedule_repo.save(scheduleTemp);
    }

    /**
     *get relevent dates for each specific doctor
     * @param drRegNo
     * @return
     */
    @Override
    public List<LocalDate> getBookingDatesByDoctorId(Long drRegNo) {
        List<ScheduleTemp> schedules = schedule_repo.findByDrRegNo(drRegNo);
        return schedules.stream()
                .map(ScheduleTemp::getDate)
                .collect(Collectors.toList());
    }

    /**
     *get doctor registration id
     * @param doctorId
     * @return
     */
    @Override
    public Optional<PatientDoctor> getDoctorById(Long doctorId) {
        return patient_DoctorRepo.findById(doctorId);
    }

}
