package com.venue.domain;


public class SeatHold {
	
	private int id;
	private int[] seatIds;

	public SeatHold(){
		
	}
	
	private int uniqueId = 0;
	private  synchronized void setId()
	{
		this.id = uniqueId++;
	}

	
	public SeatHold(int seatHoldId,int[] seatIds) {
		super();
		setId();
		this.id = seatHoldId;
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
