package com.nsbm.echannelling.labservice.service.implementation;

import com.nsbm.echannelling.labservice.model.LabReportModel;
import com.nsbm.echannelling.labservice.repository.LabReportRepository;
import com.nsbm.echannelling.labservice.service.LabReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class LabReportServiceImpl implements LabReportService {

    @Autowired
    private LabReportRepository labReportRepository;

    /**
     * upload a report
     * @param labReportModel
     * @return
     */
    @Override
    public ResponseEntity<?> uploadReport(LabReportModel labReportModel) {
        try {
            labReportRepository.save(labReportModel);
            return ResponseEntity.ok("Lab report uploaded successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    /**
     * get all available reports
     * @param pId
     * @return
     */
    @Override
    public ResponseEntity<?>  getAllPatientReports(Long pId) {
        try {
            return  ResponseEntity.ok(labReportRepository.findABypId(pId));

        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    /**
     * get all reports
     * @return
     */
    @Override
    public ResponseEntity<?>  getAllReports() {
        try {
            return  ResponseEntity.ok(labReportRepository.findAll());

        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    /**
     * view specific report
     * @param repoetid
     * @return
     */
    @Override
    public ResponseEntity<?>  getSpecificReport(Long repoetid) {
        try {
            return  ResponseEntity.ok(labReportRepository.findById(repoetid));

        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}

