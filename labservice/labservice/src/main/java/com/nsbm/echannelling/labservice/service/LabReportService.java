package com.nsbm.echannelling.labservice.service;

import com.nsbm.echannelling.labservice.model.LabReportModel;
import com.nsbm.echannelling.labservice.repository.LabReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LabReportService {

    @Autowired
    private LabReportRepository labReportRepository;

    // Save a lab report
    public LabReportModel saveLabReport(LabReportModel labReport) {
        return labReportRepository.save(labReport);
    }

    // Retrieve a lab report by ID
    public Optional<LabReportModel> getLabReportById(Long id) {
        return labReportRepository.findById(id);
    }

    // Delete a lab report by ID
    public void deleteLabReportById(Long id) {
        labReportRepository.deleteById(id);
    }

    // List all lab reports
    public Iterable<LabReportModel> getAllLabReports() {
        return labReportRepository.findAll();
    }
}
