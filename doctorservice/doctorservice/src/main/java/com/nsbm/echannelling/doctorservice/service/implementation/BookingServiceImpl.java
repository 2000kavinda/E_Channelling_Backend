package com.nsbm.echannelling.doctorservice.service.implementation;

import com.nsbm.echannelling.doctorservice.repository.BookingRepository;
import com.nsbm.echannelling.doctorservice.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    /**
     * filter bookings for specific drRegNo
     * @param drRegNo
     * @return
     */
    @Override
    public ResponseEntity<?> filterBookings(Long drRegNo) {
        try {
            return  ResponseEntity.ok(bookingRepository.findByDrId(drRegNo));

        } catch (Exception e) {

            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    /**
     * search patient
     * @param drNamePart
     * @return
     */
    @Override
    public ResponseEntity<?> getPatientByNamePart(String drNamePart) {
        try {
            return ResponseEntity.ok(bookingRepository.findByNameContaining(drNamePart));
        } catch (Exception e) {

            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    /**
     * filter bookings by date
     * @param bDay
     * @param drId
     * @return
     */
    @Override
    public ResponseEntity<?> filterBookingsByDate(LocalDate bDay, Long drId) {
        try {
            return  ResponseEntity.ok(bookingRepository.findBybDayAndDrId(bDay,drId));

        } catch (Exception e) {

            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    /**
     * get total of the appointment for specific DR
     * @param drId
     * @return
     */
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
