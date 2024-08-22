package com.nsbm.echannelling.authenticationservice.controller;

import com.nsbm.echannelling.authenticationservice.dto.UserRequest;
import com.nsbm.echannelling.authenticationservice.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("api/v1/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody UserRequest userRequest) {
        return authService.saveUser(userRequest);
    }

    @PutMapping ("/createverification")
    public ResponseEntity<?> checkAndUpdateEmail(@RequestParam String email) {

        return ResponseEntity.ok(authService.createVerification(email));
    }

    @PutMapping ("/updatepw")
    public ResponseEntity<?> updatePW(@RequestParam String email, @RequestParam String code,@RequestParam String newPassword) {

        return ResponseEntity.ok(authService.updatePassword(email,code,newPassword));
    }

    @GetMapping ("/login")
    public ResponseEntity<?> login(@RequestParam String email, @RequestParam String pw) {

        return ResponseEntity.ok(authService.login(email,pw));
    }
}
