package com.bus.reservation.repository;

import com.bus.reservation.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
    Customer findByEmailAndPassword(String email, String password);
}
