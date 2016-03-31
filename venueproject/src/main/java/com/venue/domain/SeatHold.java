package com.venue.domain;

import java.util.ArrayList;
import java.util.List;

public class SeatHold {
	private List<Seat> heldSeats = new ArrayList<Seat>();
	private static int uniqueIdCounter = 0;
	private String customerEmail;
	private int seatHoldId = 0;

	public SeatHold() {
		this.seatHoldId = getNextUniqueId();
	}
	
	public static int getNextUniqueId() {
		return uniqueIdCounter++;
	}

	public void addSeats(List<Seat> seats) {
		heldSeats.addAll(seats);
	}

	public int getSeatHoldId() {
		return seatHoldId;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public List<Seat> getHeldSeats() {
		return heldSeats;
	}
}
