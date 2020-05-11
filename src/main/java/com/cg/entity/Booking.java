package com.cg.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Booking {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int  bookingId;
	@Column
	private String userId;
	@Column
	private String busId;
	@Column 
	private String seatNo;
	@Column
	private LocalDate dateOfJourney;
	@Column
	private float fare;
	
	
	public Booking() {
		
		// TODO Auto-generated constructor stub
	}


	public Booking(int bookingId, String userId, String busId, String seatNo, LocalDate dateOfJourney,
			float fare) {
		super();
		this.bookingId = bookingId;
		this.userId = userId;
		this.busId = busId;
		this.seatNo = seatNo;
		this.dateOfJourney = dateOfJourney;
		this.fare = fare;
	}


	public int getBookingId() {
		return bookingId;
	}





	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}





	public String getUserId() {
		return userId;
	}





	public void setUserId(String userId) {
		this.userId = userId;
	}





	public String getBusId() {
		return busId;
	}





	public void setBusId(String busId) {
		this.busId = busId;
	}





	public LocalDate getDateOfJourney() {
		return dateOfJourney;
	}





	public void setDateOfJourney(LocalDate dateOfJourney) {
		this.dateOfJourney = dateOfJourney;
	}





	public float getFare() {
		return fare;
	}





	public void setFare(float fare) {
		this.fare = fare;
	}







	public String getSeatNo() {
		return seatNo;
	}







	public void setSeatNo(String seatNo) {
		this.seatNo = seatNo;
	}

	
	
	
	  
	
	
	
	
	
}
