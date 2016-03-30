package com.venue.domain;

import java.rmi.server.UID;
import java.util.List;

public class SeatHold {
	
	private int id;
	private Level level;
	private List<Row> rows;
	

	public SeatHold(){
		
	}
	
	private int uniqueId = 0;
	private  synchronized void setId()
	{
		this.id = uniqueId++;
	}

	
	public SeatHold( Level level, List<Row> rows) {
		super();
		setId();
		this.level = level;
		this.rows = rows;
		
	}
	
	public int getId()
	{
	    return id;
	}
	
	
	public Level getLevel() {
		return level;
	}

	public List<Row> getRows() {
		return rows;
	}

	

	
	
	
	

}
