package com.nsbm.echannelling.labservice.controller;

import com.nsbm.echannelling.labservice.model.LabReportModel;
import com.nsbm.echannelling.labservice.service.implementation.LabReportServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/lab-reports")
public class LabReportController {

    @Autowired
    private LabReportServiceImpl labReportService;

    /**
     * upload a lab report for specific appointment
     * @param labReportModel
     * @return
     */
    @PostMapping("upload")
    public ResponseEntity<?> uploadReport(@RequestBody LabReportModel labReportModel) {
        return labReportService.uploadReport(labReportModel);
    }

    /**
     * get all reports for specific patient - when inside the patient profile
     * @param pId
     * @return
     */
    @GetMapping("/getPatientReports")
    public ResponseEntity<?> filterPatientReports(@RequestParam Long pId) {
        return labReportService.getAllPatientReports(pId);

    }

    /**
     * retrieve all reports in the system
     * @return
     */
    @GetMapping("/getAllReports")
    public ResponseEntity<?> getAllReports() {
        return labReportService.getAllReports();

    }

    /**
     * get full data for selected report id
     * @param repoetid
     * @return
     */
    @GetMapping("/getSelectedReport")
    public ResponseEntity<?> getSelectedReport(@RequestParam Long repoetid) {
        return labReportService.getSpecificReport(repoetid);

    }


}
