package com.bus.reservation.repository;

import com.bus.reservation.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {
    Booking[] findByCustomerId(Long id);
}
