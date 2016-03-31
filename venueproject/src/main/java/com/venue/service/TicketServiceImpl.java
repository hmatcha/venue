package com.venue.service;

import java.util.Optional;

import org.apache.log4j.Logger;

import com.venue.domain.SeatHold;
import com.venue.domain.Venue;

public class TicketServiceImpl implements TicketService {
	private static Logger log = Logger.getLogger(TicketServiceImpl.class);
	
	private Venue venue;

	public TicketServiceImpl(Venue venue) {
		super();
		this.venue = venue;
	}

	public int numSeatsAvailable(Optional<Integer> venueLevel) {
		int availableSeats = 0;

		if (venueLevel.isPresent()) {
			int levelId = venueLevel.get().intValue();
			availableSeats = venue.getNumOfAvailableSeats(levelId);
		} else {
			availableSeats = venue.getAllNumOfAvailableSeats();
		}

		return availableSeats;
	}

	// minLevel is closest to stadium i.e. 1
	// maxlevel is farther to stadium i.e. 4
	public SeatHold findAndHoldSeats(int numSeats, Optional<Integer> minLevel,
			Optional<Integer> maxLevel, String customerEmail) {
		if (numSeats <= 0) {
			throw new IllegalArgumentException("Number of seats must be greater than zero");
		}
		
		int lowLevel = minLevel.isPresent() ? minLevel.get().intValue() : 0;
		int highLevel = maxLevel.isPresent() ? maxLevel.get().intValue() : venue.getLevels().size();
		
		log.debug("highLevel :" + highLevel + " lowLevel: " + lowLevel);
		
		return venue.hold(numSeats, lowLevel, highLevel, customerEmail);
	}

	public String reserveSeats(int seatHoldId, String customerEmail) {
		try{
			venue.reserveSeats(seatHoldId, customerEmail);
			return "success";
		} catch(Exception ex) {
			log.error(ex, ex);
			return "failure";
		}
	}
}
