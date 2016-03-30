package com.venue.service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.log4j.Logger;

import com.venue.domain.Level;
import com.venue.domain.Person;
import com.venue.domain.Row;
import com.venue.domain.Seat;
import com.venue.domain.SeatHold;
import com.venue.domain.SeatStatus;
import com.venue.domain.Venue;

public class TicketServiceImpl implements TicketService {
	private Venue venue;
	private Person person;

	public TicketServiceImpl(Venue venue) {
		super();
		this.venue = venue;
		
	}

	

	static Logger log = Logger.getLogger(TicketServiceImpl.class);
	
	
	
	
	public int numSeatsAvailable(Optional<Integer> venueLevel) {
		int availableSeats =0;
		
		
			
			if(venueLevel.isPresent())
			{
				int id =  venueLevel.get().intValue();
				availableSeats = venue.getNumOfAvailableSeats(id);
			}else{
				availableSeats = venue.getAllNumOfAvailableSeats();
			}
		
			return availableSeats;
	}

	//minLevel is closest to stadium i.e. 1
	//maxlevel is farther to stadium i.e. 4
	public SeatHold findAndHoldSeats(int numSeats, Optional<Integer> minLevel, Optional<Integer> maxLevel,String customerEmail)  {
		Person person = new Person(customerEmail); 
		SeatHold seatHold = null;
		if(numSeats<=0)
			return null;
	    int lowLevel = 0;
	    int highLevel = venue.getLevels().size();
		if(minLevel.isPresent())
		{
			lowLevel = minLevel.get().intValue();
		}
		if(maxLevel.isPresent())
		{
			highLevel = maxLevel.get().intValue();
		}
		System.out.println("highLevel :"+highLevel+" lowLevel: "+lowLevel);
		
		for(int i=lowLevel; i<=highLevel; i++ )	
		{
			Level level = venue.getLevels().get(i);
			//System.out.println("All availableseats : "+venue.getNumOfAvailableSeats(i));
			int numOfRows=level.getRows().size();
			int totalavailableSeatsinAllRows = 0;
			
			List<Row> rows = new ArrayList<Row>();    //to use this list of rows in seatHold Constructor
			
			System.out.println("In Level = "+level.getLevelId());
			for(int j=0;j<numOfRows;j++) 
			{
				
				Row row = level.getRows().get(j);//fetching particular row from the level
				int numOfAvailableSeatsInRow = row.getNumOfAvailableSeats();
				System.out.println("numOfAvailableSeatsInRow from Row" +row.getId() +": "+numOfAvailableSeatsInRow+" numSeats :"+numSeats);
				
				if(numOfAvailableSeatsInRow>=numSeats)	 //seats available in same row			
				{
					System.out.println(row.holdSeats(numSeats));
					//if("success".equalsIgnoreCase(row.holdSeats(numSeats))) 
					{
						row.holdSeats(numSeats);
						rows.add(row);
						seatHold = new SeatHold(level, rows);
						person.setSeatHold(seatHold);
						this.person = person;
						return seatHold;	
					}	
				}
				totalavailableSeatsinAllRows += numOfAvailableSeatsInRow;
			}
			System.out.println("totalavailableSeatsinAllRows :"+totalavailableSeatsinAllRows);
			if(totalavailableSeatsinAllRows>=numSeats)  // if seats are available but in different rows
			{
				for(int k=lowLevel; k<=highLevel; k++)	
				{
					Level level2 = venue.getLevels().get(k);
					System.out.println("In level for diffrows = "+level2.getLevelId());
					for(int l=0;l<numOfRows;l++) 
					{
						System.out.println("Value of l = "+l+"   num of rows = "+ numOfRows);
						Row row = level2.getRows().get(l);
						int numOfAvailableSeatsInRow = row.getAvailableSeats().size();
						
							if("success".equalsIgnoreCase(row.holdSeats(numSeats)))
							{
								 
								numSeats -= numOfAvailableSeatsInRow;
								rows.add(row);
								System.out.println("level in seathold :"+level.getLevelName());
								
							}
							
							System.out.println("Checking seats available in different rows");
					}
					
				}
				seatHold = new SeatHold(level, rows);
				person.setSeatHold(seatHold);
				this.person = person;
				System.out.println("seatHold inside same rows :"+seatHold);
				
				return seatHold;
			}
		}
		System.out.println("seatHold inside same rows :"+seatHold);
		return seatHold;
	}

	

	public String reserveSeats(int seatHoldId, String customerEmail) {
		
		if(customerEmail.equalsIgnoreCase(person.getEmailId()))
		{
			int seatHoldIdInPerson = person.getSeatHold().getId();
			if(seatHoldId==seatHoldIdInPerson)
			{
				SeatHold seatHold = person.getSeatHold();
				for(int i=0;i< seatHold.getRows().size();i++)
				{
					for(Seat seat : seatHold.getRows().get(i).getHeldSeats())
					{
						if(SeatStatus.HELD.equals(seat.getStatus()))
							seat.setStatus(SeatStatus.RESERVED);
					}
				}
				return "success";
			}
		}
		return "failure";
		 
	}
	
}
