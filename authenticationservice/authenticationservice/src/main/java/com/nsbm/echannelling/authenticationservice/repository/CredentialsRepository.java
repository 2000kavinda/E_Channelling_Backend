package com.nsbm.echannelling.authenticationservice.repository;

import com.nsbm.echannelling.authenticationservice.model.Credential;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CredentialsRepository extends JpaRepository<Credential, Long> {
}
