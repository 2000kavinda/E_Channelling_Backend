package com.nsbm.echannelling.adminservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Doctor {

    @Id
    public Long drRegNo;
    public String drName;
    public String specialize;
    public String type;
    public String profileImage;
    public String drQualification;

}
