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
    private Long lPRegNo;
    private String lPName;
    private String labNo;
    private String lPQualification;
    private String lPProfileImage;

}
