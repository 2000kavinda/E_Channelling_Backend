package com.nsbm.echannelling.authenticationservice.service;

import com.nsbm.echannelling.authenticationservice.dto.UserRequest;
import org.springframework.http.ResponseEntity;

public interface AuthService {

    ResponseEntity<?> saveUser(UserRequest userRequest);

    ResponseEntity<?> createVerification(String email);

    ResponseEntity<?> updatePassword(String email, String code,String newPassword);

    ResponseEntity<?> login(String email, String password);
}
