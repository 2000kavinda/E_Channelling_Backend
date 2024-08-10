package com.nsbm.echannelling.adminservice.service;

import com.nsbm.echannelling.adminservice.dto.ScheduleDTO;
import com.nsbm.echannelling.adminservice.model.Schedule;
import com.nsbm.echannelling.adminservice.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ScheduleServiceImpl implements ScheduleService {

    @Autowired
    private ScheduleRepository scheduleRepository;

    @Override
    public String saveSchedule(Schedule schedule) {
        try {
            scheduleRepository.save(schedule);
            return "Schedule saved";
        } catch (Exception e) {
            return  e.getMessage();
        }
    }

    @Override
    public ResponseEntity<?>  getAllSchedules() {
        try {
            return  ResponseEntity.ok(scheduleRepository.findAllSchedulesWithDrName());

        } catch (Exception e) {

            return ResponseEntity.badRequest().body("Something went wrong");
        }
    }

    @Override
    public ResponseEntity<?>  searchScheduleWithId(LocalDate date) {
        try {
            return  ResponseEntity.ok(scheduleRepository.findByDate(date));

        } catch (Exception e) {

            return ResponseEntity.badRequest().body("Something went wrong");
        }
    }

    @Override
    public ResponseEntity<?>  updateSchedule(Long sId,Schedule newSchedule) {
        try {
            Optional<Schedule> credentialOptional = scheduleRepository.findById(sId);
            Schedule schedule = credentialOptional.get();
            schedule.setDate(newSchedule.getDate());
            schedule.setEnd(newSchedule.getEnd());
            schedule.setStart(newSchedule.getStart());
            schedule.setRoomNo(newSchedule.getRoomNo());
            schedule.setDrRegNo(newSchedule.getDrRegNo());
            return  ResponseEntity.ok(scheduleRepository.save(schedule));

        } catch (Exception e) {

            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @Override
    public ResponseEntity<?>  deleteSchedule(Long sId) {
        try {
            Optional<Schedule> credentialOptional = scheduleRepository.findById(sId);
            if (credentialOptional.isPresent())
            {
                scheduleRepository.deleteById(sId);

                return ResponseEntity.ok("Schedule deleted successfully");
            }else {
                return ResponseEntity.ok("Schedule not found");
            }

        } catch (Exception e) {

            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @Override
    public List<ScheduleDTO> getSchedulesByDoctorNamePart(String drNamePart) {
        return scheduleRepository.findSchedulesByDoctorNamePart(drNamePart);
    }


}
