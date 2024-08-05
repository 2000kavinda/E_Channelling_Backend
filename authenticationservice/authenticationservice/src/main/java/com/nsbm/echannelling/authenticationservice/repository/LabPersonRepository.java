package com.nsbm.echannelling.authenticationservice.repository;

import com.nsbm.echannelling.authenticationservice.model.LabPerson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LabPersonRepository  extends JpaRepository<LabPerson, Long> {
}
