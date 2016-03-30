package com.venue.domain;

import java.util.ArrayList;
import java.util.List;

import com.venue.domain.Seat;

public class Row {
	
	private int id;
	// have to check whether it is needed or not
	//private int numSeats;//max num of seats in each row
	
	private List<Seat> seats;//list of all seats in each row 
	
	
	public Row(int id,List<Seat> seats) {
		this.id = id;
		this.seats = seats;		
		
	}
	
	public int getId() {
		return id;
	}

	public List<Seat> getSeats() {
		return seats;
	}

	public int getNumOfAvailableSeats() {
		
		List<Seat> seats = new ArrayList<Seat>();
		int numOfavailableSeats=0;
		
		for(Seat seat : seats)
		{
			if(SeatStatus.AVAILABLE.equals(seat.getStatus()))
				numOfavailableSeats += 1;
			seats.add(seat);
			
		}
		
		return numOfavailableSeats;
		
	}
	
	public String hold(int numOfSeatsToHold){
		
		
		for(Seat seat:seats)
		{
			if(numOfSeatsToHold>0)
			{
				seat.status = SeatStatus.HELD;
				numOfSeatsToHold -= 1;
				seats.add(seat);
			}
			else
			{
				if(seats.size()>0)
					return "success";
			}
			
		}
		return "failure";
	}
	
	
}
