package com.nsbm.echannelling.authenticationservice.model;

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
    private Long pId;
    private String pName;
    private LocalDate bDay;
    private String gender;
    private String contact;
    private String pProfileImage;

}
