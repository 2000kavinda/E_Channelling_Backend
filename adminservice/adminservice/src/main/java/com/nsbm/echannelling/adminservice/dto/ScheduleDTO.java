package com.nsbm.echannelling.adminservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ScheduleDTO {

    private Long sId;
    private String drName;
    private LocalDate date;
    private LocalTime start;
    private LocalTime end;
    private String roomNo;


}
