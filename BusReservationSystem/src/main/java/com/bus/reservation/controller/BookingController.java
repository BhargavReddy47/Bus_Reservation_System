package com.bus.reservation.controller;

import com.bus.reservation.entity.Booking;
import com.bus.reservation.model.BookingRequest;
import com.bus.reservation.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
public class BookingController {

    @Autowired
    BookingService bookingService;

    @PostMapping("/book")
    public ResponseEntity<Booking> book(@RequestBody BookingRequest bookingReq){
        return new ResponseEntity<>(bookingService.book(bookingReq), HttpStatus.CREATED);
    }

    @GetMapping("/bookings")
    public ResponseEntity<Booking[]> getBookings(@RequestParam long customerId){
        return new ResponseEntity<>(bookingService.getBookings(customerId), HttpStatus.CREATED);
    }
}
