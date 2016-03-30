package com.venue.service.test;

import static org.junit.Assert.*;

import java.util.Optional;

import org.junit.Test;

import com.venue.domain.Person;
import com.venue.domain.SeatHold;
import com.venue.domain.Venue;
import com.venue.service.TicketService;
import com.venue.service.TicketServiceImpl;

public class ReserveSeatsTest {
	private Venue venue;
	private TicketService service; 
	private Person person;

	/**
	 * 
	 */
	
	public ReserveSeatsTest() {
		super();
		Person person = new Person();
		this.person = person;
		this.venue = person.populatevenue();
		this.service = new TicketServiceImpl(this.venue);
	}

	@Test
	public void Level1Reserve() {
		
		venue.getNumOfAvailableSeats(0);
		venue.getLevels().get(0).getRows().get(0).holdSeats(30);
		venue.getLevels().get(0).getRows().get(1).holdSeats(50);
		venue.getLevels().get(0).getRows().get(2).holdSeats(45);
		venue.getLevels().get(0).getRows().get(3).holdSeats(25);
		SeatHold seatHold = service.findAndHoldSeats(2,Optional.ofNullable(0),Optional.of(3),"Madhavi");
		
		service.reserveSeats(seatHold.getId(), "Madhavi");
		assertEquals("Main",seatHold.getLevel().getLevelName());
	}

}
