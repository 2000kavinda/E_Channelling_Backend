package com.nsbm.echannelling.doctorservice.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Doctor {

    @Id
    @Column(nullable = false)
    private Long drRegNo;
    private String drName;
    private String specialize;
    private String type;
    private String profileImage;
    private String drQualification;

}
