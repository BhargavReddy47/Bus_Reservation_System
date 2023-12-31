package com.bus.reservation.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long scheduleId;
    private Long customerId;
    private int noOfSeats;
    private Long amountPaid;

    @ManyToOne
    @JoinColumn(name = "scheduleId", insertable = false, updatable = false)
    private Schedule schedule;

    @ManyToOne
    @JoinColumn(name = "customerId", insertable = false, updatable = false)
    private Customer customer;

    public  Booking(){
    }

    public Booking(Long scheduleId, Long customerId, int noOfSeats, Long amountPaid) {
        this.scheduleId = scheduleId;
        this.customerId = customerId;
        this.noOfSeats = noOfSeats;
        this.amountPaid = amountPaid;
    }
}
