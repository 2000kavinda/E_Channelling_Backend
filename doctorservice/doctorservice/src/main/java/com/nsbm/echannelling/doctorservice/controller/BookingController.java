package com.nsbm.echannelling.doctorservice.controller;

import com.nsbm.echannelling.doctorservice.service.implementation.BookingServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@CrossOrigin("*")
@RestController
@RequestMapping("api/v1/booking")
public class BookingController {

    @Autowired
    private BookingServiceImpl bookingService;

    /**
     * get all bookings for the DR
     * @param drRegNo
     * @return
     */
    @GetMapping("/filter")
    public ResponseEntity<?> getAllBookings(@RequestParam Long drRegNo) {
        return bookingService.filterBookings(drRegNo);

    }

    /**
     * search patient
     * @param pNamePart
     * @return
     */
    @GetMapping("/search")
    public ResponseEntity<?> getPatientByNamePart(@RequestParam String pNamePart) {
        return ResponseEntity.ok(bookingService.getPatientByNamePart(pNamePart));
    }

    /**
     * get today bookings
     * @param date
     * @param drRegNo
     * @return
     */
    @GetMapping("/filterByDate")
    public ResponseEntity<?> getAllBookingByDate(@RequestParam LocalDate date, Long drRegNo) {
        return bookingService.filterBookingsByDate(date,drRegNo);

    }

    /**
     * get DR's appointment count
     * @param drId
     * @return
     */
    @GetMapping("/count")
    public ResponseEntity<?> getAppointmentCount(@RequestParam Long drId) {
        return ResponseEntity.ok(bookingService.getAppointmentCount(drId));
    }
}
