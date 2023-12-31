package com.bus.reservation.controller;

import com.bus.reservation.entity.Customer;
import com.bus.reservation.model.LoginRequest;
import com.bus.reservation.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins="*")
public class AuthController {

    @Autowired
    CustomerRepository customerRepository;


    @PostMapping ("/login")
    public ResponseEntity<Customer> getCustomer(@RequestBody LoginRequest loginRequest) {
        var customer = customerRepository.findByEmailAndPassword(loginRequest.getEmail(), loginRequest.getPassword());
        if(customer==null){
            return new ResponseEntity<Customer>(customer,HttpStatus.UNAUTHORIZED);
        }
        return new ResponseEntity<Customer>(customer, HttpStatus.OK);

    }
}
