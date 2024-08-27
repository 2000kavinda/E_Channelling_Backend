package com.nsbm.echannelling.labservice.model;

import jakarta.persistence.*;

@Entity
public class LabReportModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String patientId;

    @Lob
    private byte[] labReportData;

    private String labReportFileName;

    private String labReportFileType;

    // Constructors
    public LabReportModel() {}

    public LabReportModel(String patientId, byte[] labReportData, String labReportFileName, String labReportFileType) {
        this.patientId = patientId;
        this.labReportData = labReportData;
        this.labReportFileName = labReportFileName;
        this.labReportFileType = labReportFileType;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public byte[] getLabReportData() {
        return labReportData;
    }

    public void setLabReportData(byte[] labReportData) {
        this.labReportData = labReportData;
    }

    public String getLabReportFileName() {
        return labReportFileName;
    }

    public void setLabReportFileName(String labReportFileName) {
        this.labReportFileName = labReportFileName;
    }

    public String getLabReportFileType() {
        return labReportFileType;
    }

    public void setLabReportFileType(String labReportFileType) {
        this.labReportFileType = labReportFileType;
    }
}
