package com.venue.service.test;

import static org.junit.Assert.*;

import java.util.Optional;

import org.junit.Ignore;
import org.junit.Test;

import com.venue.domain.Person;
import com.venue.domain.SeatHold;
import com.venue.domain.Venue;
import com.venue.service.TicketService;
import com.venue.service.TicketServiceImpl;

public class FindAndHoldSeatsTest {

	private Venue venue;
	private TicketService service;  

	/**
	 * 
	 */
	
	
	
	public FindAndHoldSeatsTest() {
		super();
		Person person = new Person();
		this.venue = person.populatevenue();
		this.service = new TicketServiceImpl(this.venue);
	}

	@Test //total seats available in level2
	public void testTotalSeats()
	{
		
		assertEquals(2000,venue.getNumOfAvailableSeats(1));
		
	}
	
	/**
	 * 
	 */
	@Test
	public void TestAvailableSeats() {
		
		venue.getNumOfAvailableSeats(0);
		venue.getLevels().get(0).getRows().get(0).holdSeats(30);
		//venue.getLevels().get(0).getRows().get(1).holdSeats(50);
		venue.getLevels().get(0).getRows().get(2).holdSeats(45);
		venue.getLevels().get(0).getRows().get(3).holdSeats(25);
		assertEquals(1150,service.numSeatsAvailable(Optional.of(0)));
		
		
	}
	@Test
	public void TestFindAndHoldSeats() {
		
		int num = venue.getNumOfAvailableSeats(0);
		System.out.println("total seats in that level :"+num);
		for(int i=0;i<venue.getLevels().get(0).getRows().size();i++)
			venue.getLevels().get(0).getRows().get(i).holdSeats(50);
		int num2 = venue.getNumOfAvailableSeats(0);
		System.out.println("total held seats in that level :"+num2);
		
		SeatHold seatHold = service.findAndHoldSeats(2,Optional.ofNullable(0),Optional.of(3),"Madhavi");
		System.out.println("Name of the level :"+seatHold.getLevel().getLevelName());
		assertEquals("Orchestra",seatHold.getLevel().getLevelName());
		
		
	}

}
