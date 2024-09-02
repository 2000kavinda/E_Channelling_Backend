package com.nsbm.echannelling.labservice.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
public class LabReportModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long repoetid;
    private Long pId;
    private  String serviceName;
    private  String pdflink;
    private String uploadpdfname;
    private LocalDate uploaddate;
    private Double reportPrice;
}
