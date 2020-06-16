package com.upgrad.hirewheels.service;

import com.upgrad.hirewheels.entities.Booking;
import com.upgrad.hirewheels.dao.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    BookingRepository bookingRepository;

    /**
     *
     * @param booking
     * @return
     */

    public Booking addBooking(Booking booking){
        Booking successBooking = bookingRepository.save(booking);
        return successBooking;
    }

}
