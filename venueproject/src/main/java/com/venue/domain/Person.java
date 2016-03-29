package com.venue.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Person {
	private String PersonType;  //customer or owner
	private String emailId;
	
	private SeatHold seatHold;

	public Person(String PersonType, String emailId) {
		super();
		this.PersonType = PersonType;
		this.emailId = emailId;
	}
	public Person()
	{
		
	}

	public SeatHold getSeatHold() {
		return seatHold;
	}

	public void setSeatHold(SeatHold seatHold) {
		this.seatHold = seatHold;
	}
	
	
	private Venue createVenue(int[] numLevels,String[] levelNames,double[] prices,int[] rows,int[] seats)
	{
		
		Venue venue = new Venue(createLevels(numLevels,levelNames,prices,rows,seats));
		return venue;
		
	}
	
	private List<Level> createLevels(int[] numLevels,String[] levelNames,double[] prices,int[] rows,int[] seats){
		List<Level> levels = new ArrayList<Level>();
		for(int i=0;i<numLevels.length;i++){
			Level level = new Level(numLevels[i], levelNames[i], prices[i], createRows(rows[i],seats[i]));
			levels.add(level);
		}
		
		return levels;
		
	}
	private List<Row> createRows(int numRows,int numSeats)
	{
		List<Row> rows = new ArrayList<Row>();
		for(int i=0;i<numRows;i++)
		{
			Row row = new Row(i+1,createSeats(numSeats));
			rows.add(row);
		}
		return rows;

		
	}
	private List<Seat> createSeats(int numSeats)
	{
		List<Seat> seats = new ArrayList<Seat>();
		for(int i=0;i<numSeats;i++)
		{
			Seat seat = new Seat(i+1,SeatStatus.AVAILABLE);
			seats.add(seat);
		}
		return seats;
	}

}
