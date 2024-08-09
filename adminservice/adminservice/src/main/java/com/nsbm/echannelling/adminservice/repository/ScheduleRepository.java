package com.nsbm.echannelling.adminservice.repository;

import com.nsbm.echannelling.adminservice.dto.ScheduleDTO;
import com.nsbm.echannelling.adminservice.model.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {

    @Query("SELECT new com.nsbm.echannelling.adminservice.dto.ScheduleDTO(s.sId, d.drName, s.date, s.start, s.end, s.roomNo) " +
            "FROM Schedule s JOIN Doctor d ON s.drRegNo = d.drRegNo")
    List<ScheduleDTO> findAllSchedulesWithDrName();

    @Query("SELECT new com.nsbm.echannelling.adminservice.dto.ScheduleDTO(s.sId, d.drName, s.date, s.start, s.end, s.roomNo) " +
            "FROM Schedule s JOIN Doctor d ON s.drRegNo = d.drRegNo " +
            "WHERE LOWER(d.drName) LIKE LOWER(CONCAT('%', :drNamePart, '%'))")
    List<ScheduleDTO> findSchedulesByDoctorNamePart(@Param("drNamePart") String drNamePart);

}
