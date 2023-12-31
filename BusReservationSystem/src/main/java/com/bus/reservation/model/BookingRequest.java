package com.bus.reservation.model;

import lombok.Data;

@Data
public class BookingRequest {
    private Long scheduleId;
    private Long customerId;
    private int noOfSeats;
    private Long amountPaid;
}
