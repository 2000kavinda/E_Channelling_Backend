package com.nsbm.echannelling.authenticationservice.service;

import com.nsbm.echannelling.authenticationservice.dto.UserRequest;
import org.springframework.http.ResponseEntity;

public interface AuthService {
    ResponseEntity<?> saveUser(UserRequest userRequest);
    String createVerification(String email);



    String updatePassword(String email, String code);

    String login(String email, String password);
}
