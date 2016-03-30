package com.venue.domain;

import java.util.List;

import com.venue.domain.Level;

public class Venue {
	
	private List<Level> levels;
	public static List<SeatHold> seatHolds; 
	
	/**
	 * @param levels different levels in the venue
	 * creates venue and initializes List Of levels
	 */
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
	
	/**
	 * @param levelId uniquely identifies a Level 
	 * @return number of all available seats in particular level 
	 */
	
	public SeatHold hold(int numOfSeatsToHold, int minLevel, int maxLevel,String custEmail)
	{
		Level level;
		for(int i=minLevel;i<=maxLevel;i++)
		{
			level=levels.get(i);
			level.hold(numOfSeatsToHold);
		
		}
		SeatHold seatHold = new SeatHold();
		return seatHold;
		
	}

	public int getNumOfAvailableSeats(int levelId){
		Level level = levels.get(levelId);
		return level.getNumOfAvailableSeatsInAllRows();
	}
	
	/**
	 * @return number of all available seats in all different levels 
	 */
	public  int getAllNumOfAvailableSeats() {
		
		int totalNumOfAvailableSeats = 0;
		for(Level level : levels){			
			totalNumOfAvailableSeats += level.getNumOfAvailableSeatsInAllRows();
		}
		return totalNumOfAvailableSeats;
	
	}

}
