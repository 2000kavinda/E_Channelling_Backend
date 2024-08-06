package com.nsbm.echannelling.patientservice.model;


import jakarta.persistence.*;

@Entity
public class Patient_Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long drRegNo;
    private String drName;
    private String specialize;
    private String type;
    private String profileImage;
    private String drQualification;

    public Patient_Doctor(Long drRegNo) {

    }

    public Patient_Doctor() {

    }

    public Long getDrRegNo() {
        return drRegNo;
    }

    public void setDrRegNo(Long drRegNo) {
        this.drRegNo = drRegNo;
    }

    public String getDrName() {
        return drName;
    }

    public void setDrName(String drName) {
        this.drName = drName;
    }

    public String getSpecialize() {
        return specialize;
    }

    public void setSpecialize(String specialize) {
        this.specialize = specialize;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    public String getDrQualification() {
        return drQualification;
    }

    public void setDrQualification(String drQualification) {
        this.drQualification = drQualification;
    }
}
