package com.bus.reservation.repository;

import com.bus.reservation.entity.Stop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StopRepository extends JpaRepository<Stop,Long> {
}
