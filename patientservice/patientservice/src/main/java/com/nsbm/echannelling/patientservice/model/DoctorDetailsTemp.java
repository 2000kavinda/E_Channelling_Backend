package com.nsbm.echannelling.patientservice.model;

import jakarta.persistence.*;

@Entity
public class DoctorDetailsTemp {
    @Id
    private Long doctorRegNo;

    private String name;
    private String specialization;
    private String biography;
    private String credentials;
    private String email;
    private String phone;
    private String address;
    private String profilepic;

    public String getProfilepic() {
        return profilepic;
    }

    public void setProfilepic(String profilepic) {
        this.profilepic = profilepic;
    }

    public DoctorDetailsTemp() {

    }

    public Long getDoctorRegNo() {
        return doctorRegNo;
    }

    public void setDoctorRegNo(Long doctorRegNo) {
        this.doctorRegNo = doctorRegNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCredentials() {
        return credentials;
    }

    public void setCredentials(String credentials) {
        this.credentials = credentials;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
