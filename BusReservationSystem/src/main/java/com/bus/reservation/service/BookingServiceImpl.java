package com.bus.reservation.service;

import com.bus.reservation.entity.Booking;
import com.bus.reservation.model.BookingRequest;
import com.bus.reservation.repository.BookingRepository;
import com.bus.reservation.repository.CustomerRepository;
import com.bus.reservation.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    ScheduleRepository scheduleRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public Booking book(BookingRequest bookingRequest) {

        var scheduleRes = scheduleRepository.findById(bookingRequest.getScheduleId());
        if (scheduleRes.isEmpty())
            throw new NotFoundException("Schedule not found");

        var customer = customerRepository.findById(bookingRequest.getCustomerId());
        if (customer.isEmpty())
            throw new NotFoundException("Customer not found");

        var schedule = scheduleRes.get();
        if (schedule.getAvailableSeats() < bookingRequest.getNoOfSeats())
            throw new IndexOutOfBoundsException("Selected bus schedule doesn't have enough seats to book");

        var booking = new Booking(bookingRequest.getScheduleId(), bookingRequest.getCustomerId(),
                bookingRequest.getNoOfSeats(), bookingRequest.getAmountPaid());

        booking = bookingRepository.save(booking);

        schedule.setAvailableSeats(schedule.getAvailableSeats() - bookingRequest.getNoOfSeats());
        scheduleRepository.save(schedule);

        return booking;
    }

    @Override
    public  Booking[] getBookings(long customerId){
        return bookingRepository.findByCustomerId(customerId);
    }
}
