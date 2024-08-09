package com.nsbm.echannelling.doctorservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
public class Booking {

    @Id
    @GeneratedValue
    public Long bId;
    public Long drId;
    public Long pId;
    public String pName;
    public LocalDate bDay;
    public String gender;
    public String contact;


}
