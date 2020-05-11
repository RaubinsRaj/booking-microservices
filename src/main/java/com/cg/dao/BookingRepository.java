package com.cg.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cg.entity.Booking;

public interface BookingRepository extends JpaRepository<Booking,Integer>{

	@Query("from Booking where userId=?1 and dateOfJourney=?2 ")
	Booking findBookingByUserIdAndDate(String userId,LocalDate date);
	
	@Query("from Booking where userId=?1 ")
	List<Booking> findBookingByUserId(String userId);
	
	@Query("from Booking where bookingId=?1 ")
	Booking findBookingByBookingId(int bookingId);
	
}
