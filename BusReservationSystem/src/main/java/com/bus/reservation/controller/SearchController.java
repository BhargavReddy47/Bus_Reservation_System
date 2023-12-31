package com.bus.reservation.controller;

import com.bus.reservation.entity.Schedule;
import com.bus.reservation.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@RestController
@CrossOrigin(origins="*")
public class SearchController {

    @Autowired
    ScheduleRepository scheduleRepository;

    @GetMapping("/search")
    public ResponseEntity<List<Schedule>> search(@RequestParam long departureStopId, @RequestParam long arrivalStopId, @RequestParam String departureDate) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        Date date = formatter.parse(departureDate);
        return new ResponseEntity<>(scheduleRepository.searchSchedules(departureStopId, arrivalStopId, date), HttpStatus.OK);
    }
}
