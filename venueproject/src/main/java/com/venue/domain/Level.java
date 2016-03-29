package com.venue.domain;

import java.util.List;

public class Level {
	
	private List<Row> rows;
	private int levelId;
	private String levelName;
	private double price;
	
	//Constructor taking list of rows 
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
	

	
}
