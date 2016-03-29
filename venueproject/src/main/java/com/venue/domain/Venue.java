package com.venue.domain;

import java.util.List;

public class Venue {
	
	private List<Level> levels;
	
	//Constructor that takes List Of levels
	public Venue(List<Level> levels)
	{
		this.levels =levels;
	}
	
	//Empty Constructor
	public Venue()
	{
		
	}

	//
	public List<Level> getLevels() {
		return levels;
	}
	
	

}
