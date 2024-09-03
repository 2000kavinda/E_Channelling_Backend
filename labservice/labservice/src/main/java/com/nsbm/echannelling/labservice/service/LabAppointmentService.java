package com.nsbm.echannelling.labservice.service;

import com.nsbm.echannelling.labservice.model.LabAppointmentModel;

import java.util.List;

public interface LabAppointmentService {

    LabAppointmentModel saveAppointment(LabAppointmentModel labAppointmentModel);

    List<LabAppointmentModel> getAllAppointments();

    LabAppointmentModel getAppointmentById(Long id);

    void deleteAppointment(Long id);
}
