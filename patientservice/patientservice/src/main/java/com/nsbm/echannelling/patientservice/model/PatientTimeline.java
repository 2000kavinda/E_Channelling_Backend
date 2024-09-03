package com.nsbm.echannelling.patientservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity

public class PatientTimeline {

    @Id
    @GeneratedValue
    private Long id;
    private Long patientId;
    private String date;
    private String type;
    private double other;



  public PatientTimeline() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getOther() {
        return other;
    }

    public void setOther(double other) {
        this.other = other;
    }
}
