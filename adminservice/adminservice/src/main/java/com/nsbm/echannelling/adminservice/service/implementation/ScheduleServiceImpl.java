package com.nsbm.echannelling.adminservice.service.implementation;

import com.nsbm.echannelling.adminservice.dto.ScheduleDTO;
import com.nsbm.echannelling.adminservice.model.Schedule;
import com.nsbm.echannelling.adminservice.repository.ScheduleRepository;
import com.nsbm.echannelling.adminservice.service.ScheduleService;
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

    /**
     * save a new schedule to the DB
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
     * view all schedules
     * @return
     */
    @Override
    public ResponseEntity<?>  getAllSchedules() {
        try {
            return  ResponseEntity.ok(scheduleRepository.findAllSchedulesWithDrName());

        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    /**
     * filter shedules by the date
     * @param date
     * @return
     */
    @Override
    public ResponseEntity<?>  searchScheduleWithId(LocalDate date) {
        try {
            return  ResponseEntity.ok(scheduleRepository.findByDate(date));

        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    /**
     * update existing schedule information
     * @param sId
     * @param newSchedule
     * @return
     */
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

    /**
     * delete existing schedule
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
     * search schedule by entering DR. name
     * @param drNamePart
     * @return
     */
    @Override
    public ResponseEntity<?> getSchedulesByDoctorNamePart(String drNamePart) {
        try {
            return ResponseEntity.ok(scheduleRepository.findSchedulesByDoctorNamePart(drNamePart));
        }catch (Exception e) {

            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


}
