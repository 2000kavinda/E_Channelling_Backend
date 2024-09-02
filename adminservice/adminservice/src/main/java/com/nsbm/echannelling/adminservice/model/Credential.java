package com.nsbm.echannelling.adminservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Credential {

    @Id
    private Long regNo;
    private String email;
    private String password;
    private String role;
    private String code;
}
