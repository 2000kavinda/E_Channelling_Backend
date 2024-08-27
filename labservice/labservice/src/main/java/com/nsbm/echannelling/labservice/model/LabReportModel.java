package com.nsbm.echannelling.labservice.model;

import jakarta.persistence.*;

@Entity
public class LabReportModel {


@Id
private  String repoetid;
    private String patientId;


    private  String pdflink;


    private String uploadpdfname;
    private String uploaddate;




}
