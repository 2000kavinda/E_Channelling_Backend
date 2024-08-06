package com.nsbm.echannelling.patientservice.service;

import com.nsbm.echannelling.patientservice.model.Patient_Appoinment;
import com.nsbm.echannelling.patientservice.repository.Patient_AppoinmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class Patient_AppoinmentService {

    @Autowired
    private Patient_AppoinmentRepo patient_appoinmentRepo;

    public Patient_Appoinment bookAppointment(Patient_Appoinment appointment) {
        return patient_appoinmentRepo.save(appointment);
    }

    public Optional<Patient_Appoinment> getAppointmentById(Long id) {
        return patient_appoinmentRepo.findById(id);
    }

    public List<Patient_Appoinment> getAllAppointments() {
        return patient_appoinmentRepo.findAll();
    }

}
