package com.nsbm.echannelling.doctorservice.service;

import com.nsbm.echannelling.doctorservice.model.Booking;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.List;

public interface BookingService {
    ResponseEntity<?> filterBookings(Long drRegNo);

    ResponseEntity<?> getPatientByNamePart(String drNamePart);

    ResponseEntity<?> filterBookingsByDate(LocalDate bDay, Long drId);

    ResponseEntity<?> getAppointmentCount(Long drId);
}
