package com.nsbm.echannelling.adminservice.repository;

import com.nsbm.echannelling.adminservice.dto.ScheduleDTO;
import com.nsbm.echannelling.adminservice.model.Patient;
import com.nsbm.echannelling.adminservice.model.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Long> {


    @Query("SELECT p FROM Patient p WHERE LOWER(p.pName) LIKE LOWER(CONCAT('%', :name, '%'))")
    List<Patient> findByNameContaining(@Param("name") String name);
}
