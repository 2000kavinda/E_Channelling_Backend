package com.nsbm.echannelling.doctorservice.service;

import com.nsbm.echannelling.doctorservice.model.Booking;
import com.nsbm.echannelling.doctorservice.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class BookingServiceImpl implements BookingService{

    @Autowired
    private BookingRepository bookingRepository;

    @Override
    public ResponseEntity<?> filterBookings(Long drRegNo) {
        try {
            return  ResponseEntity.ok(bookingRepository.findByDrId(drRegNo));

        } catch (Exception e) {

            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @Override
    public List<Booking> getPatientByNamePart(String drNamePart) {
        return bookingRepository.findByNameContaining(drNamePart);
    }

    @Override
    public ResponseEntity<?> filterBookingsByDate(LocalDate bDay, Long drId) {
        try {
            return  ResponseEntity.ok(bookingRepository.findBybDayAndDrId(bDay,drId));

        } catch (Exception e) {

            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @Override
    public ResponseEntity<?> getAppointmentCount(Long drId) {
        try {
            long count = bookingRepository.countByDrId(drId);
            return ResponseEntity.ok(count);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
