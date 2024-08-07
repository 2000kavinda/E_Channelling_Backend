package com.nsbm.echannelling.authenticationservice.controller;

import com.nsbm.echannelling.authenticationservice.dto.UserRequest;
import com.nsbm.echannelling.authenticationservice.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody UserRequest userRequest) {
        return authService.saveUser(userRequest);
       // return ResponseEntity.ok(result);
    }

    @PutMapping ("/createverification")
    public ResponseEntity<String> checkAndUpdateEmail(@RequestParam String email) {
        String result = authService.createVerification(email);
        return ResponseEntity.ok(result);
    }

    @PutMapping ("/updatepw")
    public ResponseEntity<String> updatePW(@RequestParam String email, @RequestParam String code) {
        String result = authService.updatePassword(email,code);
        return ResponseEntity.ok(result);
    }

    @GetMapping ("/login")
    public ResponseEntity<String> login(@RequestParam String email, @RequestParam String pw) {
        String result = authService.login(email,pw);
        return ResponseEntity.ok(result);
    }
}
