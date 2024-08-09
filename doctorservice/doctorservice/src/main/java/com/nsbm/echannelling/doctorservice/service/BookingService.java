package com.nsbm.echannelling.doctorservice.service;

import com.nsbm.echannelling.doctorservice.model.Booking;
import com.nsbm.echannelling.doctorservice.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    public ResponseEntity<?> filterBookings(Long drRegNo) {
        try {
            return  ResponseEntity.ok(bookingRepository.findByDrId(drRegNo));

        } catch (Exception e) {

            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    public List<Booking> getPatientByNamePart(String drNamePart) {
        return bookingRepository.findByNameContaining(drNamePart);
    }
}
