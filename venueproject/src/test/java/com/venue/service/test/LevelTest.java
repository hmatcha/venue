package com.venue.service.test;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import com.venue.domain.Person;
import com.venue.domain.Venue;


public class LevelTest {
	private Venue venue;

	private void populatevenue() {
		Person p =new Person();
		int[] numLevels={1,2,3,4};
		String[] levelNames={"Orchestra","Main","Balcony1","Balcony2"};
		double[] prices = {100.00,75.00,50.00,40.00};
		int[] rows = {25,20,15,15};
		int[] seats = {50,100,100,100};
		Venue venue = p.createVenue(numLevels, levelNames, prices, rows, seats);
		this.venue = venue;
	}
	@Ignore
	
	public void testLevels() {
		
		populatevenue();
		
		assertEquals(4, venue.getLevels().size());
	}
	
	@Test
	public void testRows() {
		
		populatevenue();
		//testing level 3 no of rows
		assertEquals(25, venue.getLevels().get(0).getRows().size());
	}
	@Test
	public void testSeatPrive() {
		
		populatevenue();
		//testing level 3 no of rows
		assertEquals(40.00, venue.getLevels().get(3).getPrice(),0.001);
	}
	
}
