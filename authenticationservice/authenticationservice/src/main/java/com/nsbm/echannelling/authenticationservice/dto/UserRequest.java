package com.nsbm.echannelling.authenticationservice.dto;


import lombok.Data;
import java.time.LocalDate;

@Data
public class UserRequest {
    private Long regNo;
    private String email;
    private String password;
    private String role;
    private String code;

    // Doctor specific fields
    private String drName;
    private String specialize;
    private String type;
    private String profileImage;
    private String drQualification;

    // LabPerson specific fields
    private String lPName;
    private String labNo;
    private String lPQualification;

    // Patient specific fields
    private String pName;
    private LocalDate bDay;
    private String gender;
    private String contact;
}
