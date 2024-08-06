package com.nsbm.echannelling.patientservice.service;


import com.nsbm.echannelling.patientservice.model.ScheduleModel;
import com.nsbm.echannelling.patientservice.repository.ScheduleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleService {
    @Autowired
    private ScheduleRepo schedulerepo;

    public ScheduleModel addSchedule(ScheduleModel schedule) {
        return schedulerepo.save(schedule);
    }

    public List<ScheduleModel> getSchedulesByDoctorId(Long doctorId) {
        return schedulerepo.findByDrRegNo(doctorId);
    }
}
