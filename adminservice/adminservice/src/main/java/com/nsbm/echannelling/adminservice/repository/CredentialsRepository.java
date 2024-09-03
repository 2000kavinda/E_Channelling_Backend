package com.nsbm.echannelling.adminservice.repository;

import com.nsbm.echannelling.adminservice.model.Credential;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CredentialsRepository extends JpaRepository<Credential, Long> {

    Optional<Credential> findByEmail(String email);
}
