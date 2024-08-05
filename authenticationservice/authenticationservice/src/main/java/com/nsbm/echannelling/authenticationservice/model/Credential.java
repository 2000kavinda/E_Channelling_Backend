package com.nsbm.echannelling.authenticationservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Credential {

    @Id
    public Long regNo;
    public String email;
    public String password;
    public String role;
    public String code;
}
