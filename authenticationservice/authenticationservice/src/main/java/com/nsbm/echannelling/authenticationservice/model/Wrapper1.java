package com.nsbm.echannelling.authenticationservice.model;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class Wrapper1 {

    private Credential credential;
    private Doctor doctor;
    private LabPerson labPerson;
    private  Patient patient;
}
