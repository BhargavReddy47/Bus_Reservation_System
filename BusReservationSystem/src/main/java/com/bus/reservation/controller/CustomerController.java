package com.bus.reservation.controller;

import com.bus.reservation.entity.Customer;
import com.bus.reservation.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins="*")
public class CustomerController {
    @Autowired
    CustomerRepository customerRepository;

    @PostMapping("/register")
    public ResponseEntity<Customer> saveCustomer(@RequestBody Customer customer){

        return new ResponseEntity<>( customerRepository.save(customer), HttpStatus.CREATED);
    }


}
