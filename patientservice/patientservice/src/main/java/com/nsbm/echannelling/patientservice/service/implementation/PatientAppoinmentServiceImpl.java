package com.nsbm.echannelling.patientservice.service.implementation;

import com.nsbm.echannelling.patientservice.model.PatientAppoinment;
import com.nsbm.echannelling.patientservice.repository.PatientAppoinmentRepo;
import com.nsbm.echannelling.patientservice.service.PatientAppoinmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class PatientAppoinmentServiceImpl implements PatientAppoinmentService {

    @Autowired
    private PatientAppoinmentRepo patient_appoinmentRepo;

    @Override
    public PatientAppoinment bookAppointment(PatientAppoinment appointment) {
        return patient_appoinmentRepo.save(appointment);
    }
@Override
    public Optional<PatientAppoinment> getAppointmentById(Long id) {
        return patient_appoinmentRepo.findById(id);
    }
@Override
    public List<PatientAppoinment> getAllAppointments() {
        return patient_appoinmentRepo.findAll();
    }

}
