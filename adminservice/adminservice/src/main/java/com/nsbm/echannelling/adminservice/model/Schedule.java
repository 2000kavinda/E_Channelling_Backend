package com.nsbm.echannelling.adminservice.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.antlr.v4.runtime.misc.NotNull;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Data
@NoArgsConstructor
public class Schedule {

    @Id
    @GeneratedValue
    public Long sId;
    public Long drRegNo;
    public LocalDate date;
   // @Column(nullable = false)
    public LocalTime start;
    public LocalTime end;
    public String roomNo;
}
