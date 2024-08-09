package com.nsbm.echannelling.doctorservice.repository;

import com.nsbm.echannelling.doctorservice.model.Booking;
import com.nsbm.echannelling.doctorservice.model.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookingRepository extends JpaRepository<Booking,Long> {
    List<Booking> findByDrId(Long drId);
    @Query("SELECT p FROM Booking p WHERE LOWER(p.pName) LIKE LOWER(CONCAT('%', :name, '%'))")
    List<Booking> findByNameContaining(@Param("name") String name);
}
