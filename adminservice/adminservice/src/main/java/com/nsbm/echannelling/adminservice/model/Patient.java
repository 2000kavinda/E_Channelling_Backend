package com.nsbm.echannelling.adminservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
public class Patient {

    @Id
    public Long pId;
    public String pName;
    public LocalDate bDay;
    public String gender;
    public String contact;

}
