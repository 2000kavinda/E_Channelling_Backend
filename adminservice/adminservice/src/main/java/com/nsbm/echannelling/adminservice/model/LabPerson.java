package com.nsbm.echannelling.adminservice.model;

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
    private String lPProfileImage;

}
