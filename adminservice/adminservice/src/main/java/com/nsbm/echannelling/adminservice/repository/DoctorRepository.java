package com.nsbm.echannelling.adminservice.repository;

import com.nsbm.echannelling.adminservice.model.Doctor;
import com.nsbm.echannelling.adminservice.model.LabPerson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {

    @Query("SELECT d FROM Doctor d WHERE LOWER(d.drName) LIKE LOWER(CONCAT('%', :name, '%'))")
    List<Doctor> findByNameContaining(@Param("name") String name);


}
