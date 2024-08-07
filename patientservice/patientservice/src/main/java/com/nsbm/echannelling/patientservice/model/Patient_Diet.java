package com.nsbm.echannelling.patientservice.model;

import jakarta.persistence.*;

@Entity
public class Patient_Diet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Patient patient;

    private int waterIntakeCups;
    private int otherDrinkIntakeCups;
    private String dietDetails;

    public Patient_Diet(Long id) {
        this.id = id;
    }

    public Patient_Diet() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public int getWaterIntakeCups() {
        return waterIntakeCups;
    }

    public void setWaterIntakeCups(int waterIntakeCups) {
        this.waterIntakeCups = waterIntakeCups;
    }

    public int getOtherDrinkIntakeCups() {
        return otherDrinkIntakeCups;
    }

    public void setOtherDrinkIntakeCups(int otherDrinkIntakeCups) {
        this.otherDrinkIntakeCups = otherDrinkIntakeCups;
    }

    public String getDietDetails() {
        return dietDetails;
    }

    public void setDietDetails(String dietDetails) {
        this.dietDetails = dietDetails;
    }
}
