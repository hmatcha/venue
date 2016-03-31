package com.venue.service.test;

import static org.junit.Assert.*;

import java.util.Optional;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import com.venue.domain.TestFixture;
import com.venue.domain.Venue;
import com.venue.service.TicketService;
import com.venue.service.TicketServiceImpl;

public class LevelTest {
	private Venue venue;
	private TicketService service;
	private TestFixture person;

	public LevelTest() {
		super();
		TestFixture person = new TestFixture();
		this.person = person;
		this.venue = person.populatevenue();
		this.service = new TicketServiceImpl(this.venue);
	}

	@Test
	public void testLevels() {

		assertEquals(4, venue.getLevels().size());
	}

	@Test
	public void testRows() {

		assertEquals(2, venue.getLevels().get(0).getRows().size());
	}

	@Test
	public void testSeatPrice() {

		assertEquals(40.00, venue.getLevels().get(3).getPrice(), 0.001);
	}

	@Test
	public void testTotalSeats() {

		assertEquals(10, venue.getNumOfAvailableSeats(0));

	}

	@Test
	public void testHoldFuction() {
		venue.getNumOfAvailableSeats(0);
		venue.getLevels().get(0).getRows().get(0).hold(10);
		venue.getLevels().get(0).getRows().get(1).hold(10);
		assertEquals(10, venue.getNumOfAvailableSeats(3));
	}

	@Test
	public void testNumOfAvailableSeats() {

		venue.getNumOfAvailableSeats(0);
		venue.getLevels().get(0).getRows().get(0).hold(10);
		venue.getLevels().get(0).getRows().get(1).hold(10);
		TicketService service = new TicketServiceImpl(this.venue);
		assertEquals(10, service.numSeatsAvailable(Optional.of(3)));// how to
																	// test no
																	// value
	}

}
