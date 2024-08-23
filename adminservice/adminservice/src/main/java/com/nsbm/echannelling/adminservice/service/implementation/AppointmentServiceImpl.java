package com.nsbm.echannelling.adminservice.service.implementation;

import com.nsbm.echannelling.adminservice.repository.AppointmentRepository;
import com.nsbm.echannelling.adminservice.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    //retriview tha total of the appointments
    @Override
    public ResponseEntity<?> getAppointmentCount() {
        try {
            long count = appointmentRepository.count();
            return ResponseEntity.ok(count);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
