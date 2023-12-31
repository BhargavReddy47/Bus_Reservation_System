package com.bus.reservation.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.OffsetDateTime;
 @Entity
 @Data
public class Schedule {

     @Id
     @GeneratedValue(strategy = GenerationType.AUTO)
     private Long id;
     private Long busId;
     private OffsetDateTime departureDateTime;
     private OffsetDateTime arrivalDateTime;
     private Long departureStopId;
     private Long arrivalStopId;
     private int price;
     private int availableSeats;

     @ManyToOne
     @JoinColumn(name = "busId", insertable = false, updatable = false)
     private Bus bus;

     @ManyToOne
     @JoinColumn(name = "departureStopId", insertable = false, updatable = false)
     private Stop departureStop;

     @ManyToOne
     @JoinColumn(name = "arrivalStopId", insertable = false, updatable = false)
     private Stop arrivalStop;

 }
