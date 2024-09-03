package com.nsbm.echannelling.authenticationservice.repository;

import com.nsbm.echannelling.authenticationservice.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}
