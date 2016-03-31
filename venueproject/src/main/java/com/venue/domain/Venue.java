package com.venue.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.venue.domain.Level;

public class Venue {

	private List<Level> levels;
	public static List<SeatHold> seatHolds = new ArrayList<SeatHold>();

	/**
	 * @param levels
	 *            different levels in the venue creates venue and initializes
	 *            List Of levels
	 */
	public Venue(List<Level> levels) {
		this.levels = levels;
	}

	// Empty Constructor
	public Venue() {

	}

	//
	public List<Level> getLevels() {
		return levels;
	}

	/**
	 * @param levelId
	 *            uniquely identifies a Level
	 * @return number of all available seats in particular level
	 */

	public SeatHold hold(int numOfSeatsToHold, int minLevel, int maxLevel,
			String customerEmail) {
		SeatHold seatHold = null;
		for (int i = minLevel; i <= maxLevel; i++) {
			Level level = levels.get(i);
			List<Seat> heldSeats = level.hold(numOfSeatsToHold);

			if (!heldSeats.isEmpty()) {
				seatHold = new SeatHold();
				seatHold.setCustomerEmail(customerEmail);

				seatHold.addSeats(heldSeats);
			} else {
				continue;
			}
		}

		// If the total venue is full, we return the null SeatHold object. We
		// could throw an Exception here.
		return seatHold;
	}

	public int getNumOfAvailableSeats(int levelId) {
		Level level = levels.get(levelId);
		return level.getNumOfAvailableSeatsInAllRows();
	}

	/**
	 * @return number of all available seats in all different levels
	 */
	public int getAllNumOfAvailableSeats() {

		int totalNumOfAvailableSeats = 0;
		for (Level level : levels) {
			totalNumOfAvailableSeats += level.getNumOfAvailableSeatsInAllRows();
		}
		
		return totalNumOfAvailableSeats;
	}

	public void reserveSeats(int seatHoldId, String customerEmail) throws InvalidSeatHoldIdException {
		Iterator<SeatHold> seatHoldIterator = seatHolds.iterator();
		
		while(seatHoldIterator.hasNext()) {
			SeatHold seatHold = seatHoldIterator.next();
			
			if(seatHoldId == seatHold.getSeatHoldId()) {
				List<Seat> heldSeats = seatHold.getHeldSeats();
				reserveSeats(heldSeats);
				
				seatHoldIterator.remove();
			}
		}
		
		throw new InvalidSeatHoldIdException("Invalid seat hold id " + seatHoldId);
	}

	private void reserveSeats(List<Seat> heldSeats) {
		for(Seat headSeat : heldSeats) {
			headSeat.setStatus(SeatStatus.RESERVED);
		}
	}
}
