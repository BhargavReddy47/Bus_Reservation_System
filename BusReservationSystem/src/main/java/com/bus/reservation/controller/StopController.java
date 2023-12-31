package com.bus.reservation.controller;

import com.bus.reservation.entity.Stop;
import com.bus.reservation.repository.StopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins="*")
public class StopController {
    @Autowired
    StopRepository stopRepository;
    @GetMapping("/stops")
    public List<Stop> getAllStops(){
        return stopRepository.findAll();
    }
}
