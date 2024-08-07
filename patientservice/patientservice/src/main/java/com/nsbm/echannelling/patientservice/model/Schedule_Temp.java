package com.nsbm.echannelling.patientservice.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
public class Schedule_Temp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sId;
    private Long drRegNo;
    private LocalDate date;
    private LocalTime start;
    private LocalTime end;
    private String roomNo;


    public Schedule_Temp() {

    }

    public Long getsId() {
        return sId;
    }

    public void setsId(Long sId) {
        this.sId = sId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Long getDrRegNo() {
        return drRegNo;
    }

    public void setDrRegNo(Long drRegNo) {
        this.drRegNo = drRegNo;
    }

    public LocalTime getStart() {
        return start;
    }

    public void setStart(LocalTime start) {
        this.start = start;
    }

    public LocalTime getEnd() {
        return end;
    }

    public void setEnd(LocalTime end) {
        this.end = end;
    }

    public String getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(String roomNo) {
        this.roomNo = roomNo;
    }
}
