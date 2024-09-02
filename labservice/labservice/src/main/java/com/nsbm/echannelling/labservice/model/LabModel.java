package com.nsbm.echannelling.labservice.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class LabModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long serviceNumber;
    private String serviceName;
    private String roomNumber;
    private String price;
    private String description;
    private String preparation;
}
