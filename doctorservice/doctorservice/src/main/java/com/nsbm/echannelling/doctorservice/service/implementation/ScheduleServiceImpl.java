package com.nsbm.echannelling.doctorservice.service.implementation;

import com.nsbm.echannelling.doctorservice.model.Schedule;
import com.nsbm.echannelling.doctorservice.repository.ScheduleRepository;
import com.nsbm.echannelling.doctorservice.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ScheduleServiceImpl implements ScheduleService {

    @Autowired
    private ScheduleRepository scheduleRepository;

    /**
     * filter schedules by drRegNo
     * @param drRegNo
     * @return
     */
    @Override
    public ResponseEntity<?> filterSchedules(Long drRegNo) {
        try {
            return  ResponseEntity.ok(scheduleRepository.findByDrRegNo(drRegNo));

        } catch (Exception e) {

            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    /**
     * save new schedule for specific DR
     * @param schedule
     * @return
     */
    @Override
    public String saveSchedule(Schedule schedule) {
        try {
            scheduleRepository.save(schedule);
            return "Schedule saved";
        } catch (Exception e) {
            return  e.getMessage();
        }
    }

    /**
     * update selected schedule
     * @param sId
     * @param newSchedule
     * @return
     */
    @Override
    public ResponseEntity<?>  updateSchedule(Long sId, Schedule newSchedule) {
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

    /**
     * delete selected schedule
     * @param sId
     * @return
     */
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


    /**
     * get today's total time for DR
     * @param drRegNo
     * @param date
     * @return
     */
    @Override
    public ResponseEntity<?> getTotalTime(Long drRegNo, LocalDate date) {
       try {
            List<Schedule> schedules = scheduleRepository.findByDrRegNoAndDate(drRegNo, date);

            return ResponseEntity.ok(schedules.stream()
                    .mapToLong(schedule -> Duration.between(schedule.getStart(), schedule.getEnd()).toMinutes())
                    .sum() / 60);
        }catch (Exception e) {

            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    /**
     * get total room count for the DR
     * @param date
     * @param drRegNo
     * @return
     */
    @Override
    public ResponseEntity<?> getTotalRoomCount(LocalDate date, Long drRegNo) {
        try {
            return ResponseEntity.ok(scheduleRepository.countDistinctRoomNoByDateAndDrRegNo(date, drRegNo));
        }catch (Exception e) {

            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


}
