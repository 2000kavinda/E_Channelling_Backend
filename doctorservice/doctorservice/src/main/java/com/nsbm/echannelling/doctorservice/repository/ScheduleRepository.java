package com.nsbm.echannelling.doctorservice.repository;

import com.nsbm.echannelling.doctorservice.model.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface ScheduleRepository extends JpaRepository <Schedule,Long> {
    //    Optional<Schedule> findByDrID(long drRegNo);
    List<Schedule> findByDrRegNo(Long drRegNo);

    List<Schedule> findByDrRegNoAndDate(Long drRegNo, LocalDate date);

    @Query("SELECT COUNT(DISTINCT s.roomNo) FROM Schedule s WHERE s.date = :date AND s.drRegNo = :drRegNo")
    Long countDistinctRoomNoByDateAndDrRegNo(@Param("date") LocalDate date, @Param("drRegNo") Long drRegNo);



}
