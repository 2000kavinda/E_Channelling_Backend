package com.nsbm.echannelling.authenticationservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class LabPerson {

    @Id
    public Long lPRegNo;
    public String lPName;
    public String labNo;
    public String lPQualification;

}
