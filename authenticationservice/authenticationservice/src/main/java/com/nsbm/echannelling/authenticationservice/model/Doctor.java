package com.nsbm.echannelling.authenticationservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Doctor {

    @Id
    private Long drRegNo;
    private String drName;
    private String specialize;
    private String type;
    private String profileImage;
    private String drQualification;
    
}
