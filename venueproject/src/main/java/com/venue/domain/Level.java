package com.venue.domain;

import java.util.List;

/**
 * @author 
 *
 */
public class Level {
	
	
	private List<Row> rows;
	private int levelId;
	private String levelName;
	private double price;
	
	
	
	/**
	 * @param Id  uniquely identifies each row
	 * @param levelName  name of level
	 * @param price  each seat price in this level 
	 * @param rows number of rows in this level
	 */
	public Level(int Id, String levelName,double price,List<Row> rows)
	{
		this.levelId=Id;
		this.levelName = levelName;
		this.price=price;
		this.rows=rows;
		
		
	}
	
	//Empty Constructor 
	public Level()
	{
		
	}

	public List<Row> getRows() {
		return rows;
	}

	public int getLevelId() {
		return levelId;
	}

	public String getLevelName() {
		return levelName;
	}

	public double getPrice() {
		return price;
	}
	
	/**
	 * @return seats available in all rows
	 * sum of available seats in each row
	 * 
	 */
	public int getNumOfAvailableSeatsInAllRows(){
		int availableSeats = 0;
		
		 for(Row row : rows)
		 {
			 availableSeats += row.getNumOfAvailableSeats();
		 }
		return availableSeats;
	}

	
}
