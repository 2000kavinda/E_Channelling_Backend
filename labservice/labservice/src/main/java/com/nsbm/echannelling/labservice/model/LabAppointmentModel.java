package com.nsbm.echannelling.labservice.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Data
@NoArgsConstructor
public class LabAppointmentModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long appointmentNumber;

    private String name;
    private int age;
    private String email;
    private String contact;
    private LocalTime time;
    private LocalDate date;
    private String allergies;
    private String service;
    private String pacientId;
}
