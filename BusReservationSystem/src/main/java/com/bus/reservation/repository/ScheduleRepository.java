package com.bus.reservation.repository;

import com.bus.reservation.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface ScheduleRepository extends JpaRepository<Schedule,Long> {

     @Query(value = "select * from schedule where departure_stop_id = ?1 and arrival_stop_id = ?2 and CAST(departure_date_time AS date) = ?3", nativeQuery = true)
     List<Schedule> searchSchedules(long departureStopId, long arrivalStopId, Date departureDate);
}