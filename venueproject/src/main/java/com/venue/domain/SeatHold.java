package com.venue.domain;

import java.util.List;

public class SeatHold {
	
	private int id;
	private Level level;
	private Row row;
	private List<Seat> seats;

	
	public SeatHold(int id, Level level, Row row, List<Seat> seats) {
		super();
		this.id = id;
		this.level = level;
		this.row = row;
		this.seats = seats;
	}

	public int getId() {
		return id;
	}

	public Level getLevel() {
		return level;
	}

	public Row getRow() {
		return row;
	}

	public List<Seat> getSeats() {
		return seats;
	}
	
	
	

}
