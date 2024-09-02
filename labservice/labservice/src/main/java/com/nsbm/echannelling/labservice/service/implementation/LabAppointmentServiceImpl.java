package com.nsbm.echannelling.labservice.service.implementation;

import com.nsbm.echannelling.labservice.model.LabAppointmentModel;
import com.nsbm.echannelling.labservice.repository.LabAppointmentServiceRepository;
import com.nsbm.echannelling.labservice.service.LabAppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LabAppointmentServiceImpl implements LabAppointmentService {
    @Autowired
    private LabAppointmentServiceRepository repository;

    @Override
    public LabAppointmentModel saveAppointment(LabAppointmentModel labAppointmentModel) {
        return repository.save(labAppointmentModel);
    }

    @Override
    public List<LabAppointmentModel> getAllAppointments() {
        return repository.findAll();
    }

    @Override
    public LabAppointmentModel getAppointmentById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void deleteAppointment(Long id) {
        repository.deleteById(id);
    }
  //  impl package add move srvice impl
          //  add doc comments
}
