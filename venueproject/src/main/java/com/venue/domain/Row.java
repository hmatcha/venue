package com.venue.domain;

import java.util.ArrayList;
import java.util.List;

import com.venue.domain.Seat;

public class Row {
	
	private int id;
	// have to check whether it is needed or not
	//private int numSeats;//max num of seats in each row
	private List<Seat> totalSeats;//list of all seats in each row 
	private List<Seat> availableSeats;
	private List<Seat> heldSeats;
	
	public Row(int id,List<Seat> seats) {
		this.id = id;
		this.totalSeats = seats;
		this.availableSeats=null; //should we need to make null
		this.heldSeats=null;
		
		
	}
	
	public int getId() {
		return id;
	}
  // have to check whether it is needed or not
	/*public int getNumSeats() {
		
		return totalSeats.size();
	}*/
	

	public List<Seat> getSeats() {
		return totalSeats;
	}

	public List<Seat> getHeldSeats() {
		return heldSeats;
	}

	public List<Seat> getAvailableSeats() {
		return availableSeats;
	}

	public int getNumOfAvailableSeats() {
		
		List<Seat> seats = new ArrayList<Seat>();
		int numOfavailableSeats=0;
		
		for(Seat seat : totalSeats)
		{
			if(SeatStatus.AVAILABLE.equals(seat.getStatus()))
				numOfavailableSeats += 1;
			seats.add(seat);
			
		}
		this.availableSeats = new ArrayList<Seat>();
		this.availableSeats.addAll(seats);
		return numOfavailableSeats;
		
	}
	public String holdSeats(int num){
		List<Seat> heldSeats = new ArrayList<Seat>();
		System.out.println("Available seats in Row object :"+availableSeats.size());
		for(Seat seat:availableSeats)
		{
			if(num>0)
			{
				seat.status = SeatStatus.HELD;
				num -= 1;
				
				heldSeats.add(seat);
			}
			else
			{
				if(heldSeats.size()>0)
					this.heldSeats = heldSeats;
				return "success";
				
			}
			
		}
		availableSeats.removeAll(heldSeats);
		return "failure";
	}
	
	
}
