package com.nsbm.echannelling.adminservice.service;

import org.springframework.http.ResponseEntity;

public interface AppointmentService {
    ResponseEntity<?> getAppointmentCount();
}
