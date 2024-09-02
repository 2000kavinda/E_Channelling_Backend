package com.nsbm.echannelling.adminservice.repository;

import com.nsbm.echannelling.adminservice.model.LabPerson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LabPersonRepository extends JpaRepository<LabPerson, Long> {

    @Query("SELECT lp FROM LabPerson lp WHERE LOWER(lp.lPName) LIKE LOWER(CONCAT('%', :name, '%'))")
    List<LabPerson> findByNameContaining(@Param("name") String name);
}
