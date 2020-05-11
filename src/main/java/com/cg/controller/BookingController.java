package com.cg.controller;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.cg.dao.BookingRepository;
import com.cg.entity.Booking;

@RestController
public class BookingController {

	@Autowired
	private BookingRepository bookRepository;
	
	@Autowired
	RestTemplate restTemplate;
	
	@Bean
	public RestTemplate restTemplate() {
	    return new RestTemplate();
	}
	
	
	@PostMapping(path="/booking/generateTicket")
	public Booking bookTicket(@RequestBody Booking bookings )
	{
		//Booking inBooking = restTemplate.getForObject("http://localhost:3000/usermanagement/users/check/"+bookings.getUserId() , Booking.class);
		Booking inBus=restTemplate.getForObject("http://localhost:3000/busmanagement/buses/findBusesByBusId/busId/"+bookings.getBusId() , Booking.class);
		//Booking inSeat=restTemplate.getForObject("http://localhost:3000/seatmanagement/seats/bookSeat/busId/"+bookings.getBusId()+"/date/"+bookings.getDateOfJourney()+"/seat/"+bookings.getSeatNo(),Booking.class);
		Booking booking=new Booking();
		booking.setUserId(bookings.getUserId());
		booking.setDateOfJourney(bookings.getDateOfJourney());
		booking.setBusId(inBus.getBusId());
		
		booking.setSeatNo(bookings.getSeatNo());
		booking.setFare(inBus.getFare());
		return bookRepository.save(booking);
		
	}
	
	
	
	@PostMapping(path="/booking/userBookingDetails")
	public List<Booking> allBookingDetails(@RequestBody Booking bookings )
	{
		Booking inBooking = restTemplate.getForObject("http://localhost:3000/usermanagement/users/check/"+bookings.getUserId() , Booking.class);
			return bookRepository.findBookingByUserId(inBooking.getUserId());
	}
	
	
	
	
	
//	@GetMapping(path="/booking/cancelBooking/userId/{userId}/dateofjourney/{date}")
//	public Booking cancelBooking(@PathVariable String userId ,@PathVariable String date)
//	{
//		
//		
//		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//		LocalDate date1=LocalDate.parse(date,formatter);
//		Booking booking=bookRepository.findBookingByUserIdAndDate(userId, date1);
//		return booking;
//		
//	}
	
	@GetMapping(path="/booking/generateReport")
	public List<Booking> displayAllBookings()
	{
		return	bookRepository.findAll();
	}
	
	@GetMapping(path="/booking/bookingId/{bookingId}")
	public Booking findByBookingId(int bookingId)
	{
		return	bookRepository.findBookingByBookingId(bookingId);
	}
	
	
}
