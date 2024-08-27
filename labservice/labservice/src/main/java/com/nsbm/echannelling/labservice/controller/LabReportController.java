package com.nsbm.echannelling.labservice.controller;

import com.nsbm.echannelling.labservice.model.LabReportModel;
import com.nsbm.echannelling.labservice.service.LabReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@RestController
@RequestMapping("/lab-reports")
public class LabReportController {

    @Autowired
    private LabReportService labReportService;

    private static final long MAX_ALLOWED_FILE_SIZE = 5 * 1024 * 1024; // 5 MB

    @PostMapping("/upload")
    public ResponseEntity<String> uploadLabReport(@RequestParam("patientId") String patientId,
                                                  @RequestParam("labReport") MultipartFile file) {
        try {
            if (file.isEmpty()) {
                return ResponseEntity.badRequest().body("File is empty.");
            }

            // Check file size if necessary
            long fileSize = file.getSize();
            if (fileSize > MAX_ALLOWED_FILE_SIZE) {
                return ResponseEntity.badRequest().body("File size exceeds limit.");
            }

            LabReportModel labReport = new LabReportModel(
                    patientId,
                    file.getBytes(),
                    file.getOriginalFilename(),
                    file.getContentType()
            );
            labReportService.saveLabReport(labReport);

            return ResponseEntity.ok("Lab report uploaded successfully.");
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to process the file.");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An unexpected error occurred: " + e.getMessage());
        }
    }

    @GetMapping("/view/{id}")
    public ResponseEntity<byte[]> downloadLabReport(@PathVariable Long id) {
        Optional<LabReportModel> labReportOptional = labReportService.getLabReportById(id);

        if (labReportOptional.isPresent()) {
            LabReportModel labReport = labReportOptional.get();

            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + labReport.getLabReportFileName() + "\"")
                    .contentType(org.springframework.http.MediaType.parseMediaType(labReport.getLabReportFileType()))
                    .body(labReport.getLabReportData());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @GetMapping("/list/id")
    public ResponseEntity<Iterable<LabReportModel>> listLabReports() {
        return ResponseEntity.ok(labReportService.getAllLabReports());
    }
}
