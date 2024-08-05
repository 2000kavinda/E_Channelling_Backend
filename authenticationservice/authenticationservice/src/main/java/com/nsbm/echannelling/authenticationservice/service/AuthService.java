package com.nsbm.echannelling.authenticationservice.service;

import com.nsbm.echannelling.authenticationservice.dto.UserRequest;

public interface AuthService {
    void saveUser(UserRequest userRequest);
}
