package com.venue.domain;

import java.util.ArrayList;
import java.util.List;

import com.venue.domain.Seat;

public class Row {
	
	private int id;
	// have to check whether it is needed or not
	private int numSeats;//max num of seats in each row
	private List<Seat> totalSeats;//list of all seats in each row 
	private List<Seat> availableSeats;
	private List<Seat> holdSeats;
	
	public Row(int id,List<Seat> seats) {
		this.id = id;
		this.totalSeats = seats;
		
	}
	
	public int getId() {
		return id;
	}
  // have to check whether it is needed or not
	public int getNumSeats() {
		
		return totalSeats.size();
	}
	

	public List<Seat> getSeats() {
		return totalSeats;
	}

	

	public int getNumOfAvailableSeats() {
		
		List<Seat> availableSeats = new ArrayList<Seat>();
		int numOfavailableSeats=0;
		
		for(Seat seat : totalSeats)
		{
			if(SeatStatus.AVAILABLE.equals(seat.getStatus()))
				numOfavailableSeats += 1;
			availableSeats.add(seat);
			
		}
		this.availableSeats = availableSeats;
		return numOfavailableSeats;
		
	}
	
	
}
