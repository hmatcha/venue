package com.venue.service.test;

import static org.junit.Assert.assertEquals;

import java.util.Optional;

import org.junit.Ignore;
import org.junit.Test;

import com.venue.domain.Level;
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

	@Ignore //total seats available in level2
	public void testTotalSeats()
	{
		
		assertEquals(10,venue.getNumOfAvailableSeats(1));
		
	}
	
	/**
	 * 
	 */
	@Ignore
	public void TestAvailableSeats() {
		
		venue.getNumOfAvailableSeats(0);
		venue.getLevels().get(0).getRows().get(0).holdSeats(5);
		
		assertEquals(5,service.numSeatsAvailable(Optional.of(0)));
		
		
	}
	@Test
	public void TestFindAndHoldSeats() {
		
		int num = venue.getNumOfAvailableSeats(0);
		System.out.println("total seats in  level 1 :"+num);
		
		for(int j=0;j<venue.getLevels().size();j++)
		{	
			Level level= venue.getLevels().get(j);
			for(int i=0;i<level.getRows().size();i++)
			level.getRows().get(i).holdSeats(2);
		}
		int num2 = venue.getNumOfAvailableSeats(0);
		System.out.println("total seats initial held in level 1  :"+num2);
		
		SeatHold seatHold = service.findAndHoldSeats(2,Optional.of(2),Optional.empty(),"Madhavi");
		System.out.println("Inside test :"+seatHold.getLevel().getLevelName());
		int num3 = venue.getNumOfAvailableSeats(0);
		System.out.println("total seats after held in level 1  :"+num3);
		System.out.println("Seats in seatHold object = "+seatHold.getRows().get(0).getSeats().size());
		assertEquals("Balcony2",seatHold.getLevel().getLevelName());
		
		
	}

}
