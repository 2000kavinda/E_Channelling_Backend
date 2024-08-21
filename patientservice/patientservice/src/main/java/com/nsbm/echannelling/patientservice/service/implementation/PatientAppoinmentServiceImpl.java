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


    // Inserts the repository dependency for PatientAppoinment
    @Autowired
    private PatientAppoinmentRepo patient_appoinmentRepo;

    //book and save an appoinment in db
    @Override
    public PatientAppoinment bookAppointment(PatientAppoinment appointment) {
        return patient_appoinmentRepo.save(appointment);
    }

    //Retrieves an appointment by its AppointmentId
@Override
    public Optional<PatientAppoinment> getAppointmentById(Long id) {
        return patient_appoinmentRepo.findById(id);
    }

    // Retrieves all appointments from the db(appoinment list)
    @Override
    public List<PatientAppoinment> getAllAppointments() {
        return patient_appoinmentRepo.findAll();
    }

}
