package com.venue.domain;

public class Seat {

	//TODO change this to enum
	SeatStatus status;
	
	//Add int number (seat number)

	private int id;
	
	
	
	public Seat(int id,SeatStatus status) {
		super();
		this.status = SeatStatus.AVAILABLE;
		this.id = id;
	}

	public SeatStatus getStatus() {
		return status;
	}

	public void setStatus(SeatStatus status) {
		this.status = status;
	}
	

}
