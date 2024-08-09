package com.nsbm.echannelling.doctorservice.controller;

import com.nsbm.echannelling.doctorservice.model.Booking;
import com.nsbm.echannelling.doctorservice.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("api/v1/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @GetMapping("/filter")
    public ResponseEntity<?> getAllBookings(@RequestParam Long drRegNo) {
        return bookingService.filterBookings(drRegNo);

    }
    @GetMapping("/search")
    public ResponseEntity<List<Booking>> getPatientByNamePart(@RequestParam String pNamePart) {
        List<Booking> schedules = bookingService.getPatientByNamePart(pNamePart);
        return ResponseEntity.ok(schedules);
    }

    @GetMapping("/filterByDate")
    public ResponseEntity<?> getAllBookingByDate(@RequestParam LocalDate date, Long drRegNo) {
        return bookingService.filterBookingsByDate(date,drRegNo);

    }

    @GetMapping("/count")
    public ResponseEntity<?> getAppointmentCount(@RequestParam Long drId) {
        return ResponseEntity.ok(bookingService.getAppointmentCount(drId));
    }
}
