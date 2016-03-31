package com.venue.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Row {

	private int id;
	// have to check whether it is needed or not
	// private int numSeats;//max num of seats in each row

	private List<Seat> seats;// list of all seats in each row

	public Row(int id, List<Seat> seats) {
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
		int numOfavailableSeats = 0;

		for (Seat seat : seats) {
			if (SeatStatus.AVAILABLE.equals(seat.getStatus()))
				numOfavailableSeats += 1;
		}

		return numOfavailableSeats;
	}

	public List<Seat> hold(int numOfSeatsToHold) {
		
		if(numOfSeatsToHold > seats.size() || numOfSeatsToHold > getNumOfAvailableSeats()) {
			return Collections.emptyList();
		}
		
		List<Seat> heldSeats = new ArrayList<Seat>();
		for(Seat seat : seats) {
			if(heldSeats.size() == numOfSeatsToHold) {
				return heldSeats;
			}
			
			if (SeatStatus.AVAILABLE.equals(seat.getStatus())) {
				seat.setStatus(SeatStatus.HELD);
				heldSeats.add(seat);
			}
		}
		
		return heldSeats;
	}

}
