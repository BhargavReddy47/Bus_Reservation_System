package com.bus.reservation.service;

import com.bus.reservation.entity.Booking;
import com.bus.reservation.model.BookingRequest;

public interface BookingService {
    Booking book(BookingRequest bookingRequest);
    Booking[] getBookings(long customerId);
}
