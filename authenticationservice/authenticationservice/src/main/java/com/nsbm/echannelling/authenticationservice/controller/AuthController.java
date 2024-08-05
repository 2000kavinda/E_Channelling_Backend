package com.nsbm.echannelling.authenticationservice.controller;

import com.nsbm.echannelling.authenticationservice.dto.UserRequest;
import com.nsbm.echannelling.authenticationservice.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody UserRequest userRequest) {
        authService.saveUser(userRequest);
        return ResponseEntity.ok("User registered successfully");
    }
}
