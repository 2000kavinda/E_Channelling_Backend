package com.nsbm.echannelling.adminservice.controller;

import com.nsbm.echannelling.adminservice.service.AppointmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/appointment")
public class AppointmentController {

    @Autowired
    private AppointmentServiceImpl appointmentService;

    @GetMapping("/count")
    public ResponseEntity<?> getAppointmentCount() {
        return ResponseEntity.ok(appointmentService.getAppointmentCount());
    }

}
