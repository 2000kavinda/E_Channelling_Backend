package com.nsbm.echannelling.patientservice.model;

import jakarta.persistence.*;

@Entity
public class Patient_MedicalHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Patient patient;

    private String disease;
    private String description;



}
