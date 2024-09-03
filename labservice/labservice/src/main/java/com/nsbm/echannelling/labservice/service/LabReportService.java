package com.nsbm.echannelling.labservice.service;

import com.nsbm.echannelling.labservice.model.LabReportModel;
import org.springframework.http.ResponseEntity;

public interface LabReportService {
    ResponseEntity<?> uploadReport(LabReportModel labReportModel);

    ResponseEntity<?>  getAllPatientReports(Long pId);

    ResponseEntity<?>  getAllReports();

    ResponseEntity<?>  getSpecificReport(Long repoetid);
}
