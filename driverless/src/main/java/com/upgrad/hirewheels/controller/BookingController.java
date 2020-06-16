package com.upgrad.hirewheels.controller;

import com.upgrad.hirewheels.entities.Booking;
import com.upgrad.hirewheels.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/booking")
public class BookingController {

    @Autowired
    BookingService bookingService;

    @PostMapping("/book")
    public ResponseEntity booking(@RequestBody Booking vehicle) {
        Booking responseBooking = bookingService.addBooking(vehicle);
        return ResponseEntity.ok(responseBooking);
    }
}
