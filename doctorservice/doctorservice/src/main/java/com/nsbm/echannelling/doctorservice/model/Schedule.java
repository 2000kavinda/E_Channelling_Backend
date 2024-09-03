package com.nsbm.echannelling.doctorservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Data
@NoArgsConstructor
public class Schedule {

    @Id
    @GeneratedValue
    private Long sId;
    private Long drRegNo;
    private LocalDate date;
    private LocalTime start;
    private LocalTime end;
    private String roomNo;
}
