package com.nsbm.echannelling.doctorservice.service;

import com.nsbm.echannelling.doctorservice.model.Schedule;
import com.nsbm.echannelling.doctorservice.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScheduleService {

    @Autowired
    private ScheduleRepository scheduleRepository;

    public void saveSchedule(Schedule schedule){
        scheduleRepository.save(schedule);

    }

}
