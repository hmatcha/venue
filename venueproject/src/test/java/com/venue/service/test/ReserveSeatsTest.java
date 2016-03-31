package com.venue.service.test;

import static org.junit.Assert.*;

import java.util.Optional;

import org.junit.Test;

import com.venue.domain.TestFixture;
import com.venue.domain.SeatHold;
import com.venue.domain.Venue;
import com.venue.service.TicketService;
import com.venue.service.TicketServiceImpl;

public class ReserveSeatsTest {
	private Venue venue;
	private TicketService service; 
	private TestFixture person;

	/**
	 * 
	 */
	
	public ReserveSeatsTest() {
		super();
		TestFixture person = new TestFixture();
		this.person = person;
		this.venue = person.populatevenue();
		this.service = new TicketServiceImpl(this.venue);
	}

	@Test
	public void Level1Reserve() {
		
		venue.getLevels().get(0).getRows().get(0).hold(10);
		venue.getLevels().get(0).getRows().get(1).hold(10);
		//venue.getLevels().get(0).getRows().get(2).hold(10);
		//venue.getLevels().get(0).getRows().get(3).hold(25);
		SeatHold seatHold = service.findAndHoldSeats(2,Optional.ofNullable(0),Optional.of(3),"Madhavi@gmail.com");
		
		service.reserveSeats(seatHold.getSeatHoldId(), "Madhavi@gmail.com");
		assertEquals(2,seatHold.getHeldSeats().size());
	}
}
