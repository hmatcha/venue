package com.venue.domain;

import java.util.ArrayList;
import java.util.List;

public class TestFixture {
	
	private String emailId;
	private Venue venue;
	
	private SeatHold seatHold;

	public TestFixture(String emailId) {
		super();
		
		this.emailId = emailId;
	}
	public TestFixture()
	{
		
	}

	public String getEmailId() {
		return emailId;
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
	public Venue populatevenue() {
		
		int[] numLevels={1,2,3,4};
		String[] levelNames={"Orchestra","Main","Balcony1","Balcony2"};
		double[] prices = {100.00,75.00,50.00,40.00};
		int[] rows = {2,1,1,2};
		int[] seats = {5,5,5,5};
		venue = createVenue(numLevels, levelNames, prices, rows, seats);
		return venue;
		
	}
}
