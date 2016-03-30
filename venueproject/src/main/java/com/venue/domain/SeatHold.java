package com.venue.domain;


public class SeatHold {
	
	private int id;
	private int[] seatIds;

	public SeatHold(){
		
	}
	
	private int uniqueId = 0;
	private  synchronized int setId()
	{
		return uniqueId++;
	}

	
	public SeatHold(int[] seatIds) {
		super();
		setId();
		this.id = setId();
		this.seatIds =seatIds;
	}
	
	public int[] getSeatIds() {
		return seatIds;
	}


	public int getId()
	{
	    return id;
	}
	

	

	
	
	
	

}
