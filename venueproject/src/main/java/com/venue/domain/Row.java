package com.venue.domain;

import java.util.ArrayList;
import java.util.List;

public class Row {
	
	private int id;
	// have to check whether it is needed or not
	private int numSeats;//max num of seats in each row
	private List<Seat> seats;//list of all seats in each row 
	
	public Row(int id,List<Seat> seats) {
		this.id = id;
		this.seats = seats;
		
	}
	
	public int getId() {
		return id;
	}
  // have to check whether it is needed or not
	public int getNumSeats() {
		
		return seats.size();
	}
	

	public List<Seat> getSeats() {
		return seats;
	}

	

	public int getNumOfAvailableSeats() {
		
		
		int availableSeats=0;
		for(Seat seat : seats)
		{
			if(SeatStatus.AVAILABLE.equals(seat.getStatus()))
				availableSeats += 1;
		}
		return availableSeats;
		
	}
	
}
