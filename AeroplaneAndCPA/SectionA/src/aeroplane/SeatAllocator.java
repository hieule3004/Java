package aeroplane;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class SeatAllocator {

	private Map<Seat, Passenger> allocation;

	private static final String CREW = "crew";
	private static final String BUSINESS = "business";
	private static final String ECONOMY = "economy";
	
	public SeatAllocator() {
		allocation = new HashMap<Seat, Passenger>();
	}

	@Override
	public String toString() {
		return allocation.toString();
	}
	
	private void allocateInRange(Passenger passenger,
			Seat first, Seat last) throws AeroplaneFullException {

		// TODO: Section A, Task 4
		if (!allocation.containsKey(first) && (!first.isEmergencyExit() || passenger.isAdult())) {
			allocation.put(first, passenger);
		} else {
		    if (first.equals(last)) {
		    	throw new AeroplaneFullException();
			}
			assert first.hasNext(): first + " has no next?";
			allocateInRange(passenger, first.next(), last);
		}
	}

	private static String readStringValue(BufferedReader br) throws MalformedDataException, IOException {

		String result = br.readLine();
		
		if(result == null) {
			throw new MalformedDataException();
		}
		
		return result;
		
	}

	private static int readIntValue(BufferedReader br)
			throws MalformedDataException, IOException {
		try {
			return Integer.parseInt(readStringValue(br));
		} catch(NumberFormatException e) {
			throw new MalformedDataException();
		}
	}

	private static Luxury readLuxuryValue(BufferedReader br)
			throws MalformedDataException, IOException {
		try {
			return Luxury.valueOf(readStringValue(br));
		} catch(IllegalArgumentException e) {
			throw new MalformedDataException();
		}
	}

	
	public void allocate(String filename) throws IOException, AeroplaneFullException {
		
		BufferedReader br = new BufferedReader(new FileReader(filename));

		String line;
		while((line = br.readLine()) != null) {
			try {
				if(line.equals(CREW)) {
					allocateCrew(br);
				} else if(line.equals(BUSINESS)) {
					allocateBusiness(br);
				} else if(line.equals(ECONOMY)) {
					allocateEconomy(br);
				} else {
					throw new MalformedDataException();
				}
			} catch(MalformedDataException e) {
				System.out.println("Skipping malformed line of input");
			}
		}
		
	}

	private static final Seat LAST_CREW_SEAT = new Seat(Seat.FIRST_ROW, Seat.LAST_LETTER);

	private void allocateCrew(BufferedReader br) throws IOException, MalformedDataException, AeroplaneFullException {
		String firstName = readStringValue(br);
		String lastName = readStringValue(br);
		// TODO: Section A, Task 4
		//       create a crew member using firstName and lastName
		Passenger passenger = new CrewMember(firstName, lastName);
		//       call allocateInRange with appropriate arguments
		allocateInRange(passenger, Seat.FIRST_SEAT, LAST_CREW_SEAT);
	}

	private static final Seat LAST_BUSINESS_SEAT = new Seat(15, Seat.LAST_LETTER);

	private void allocateBusiness(BufferedReader br) throws IOException, MalformedDataException, AeroplaneFullException {
		String firstName = readStringValue(br);
		String lastName = readStringValue(br);
		int age = readIntValue(br);
		Luxury luxury = readLuxuryValue(br);
		// TODO: Section A, Task 4
		//       create a business class passenger using firstName, lastName, age and luxury
		Passenger passenger = new BusinessClassPassenger(firstName, lastName, age, luxury);
		//       call allocateInRange with appropriate arguments
		allocateInRange(passenger, LAST_CREW_SEAT.next(), LAST_BUSINESS_SEAT);
	}

	private void allocateEconomy(BufferedReader br) throws IOException, MalformedDataException, AeroplaneFullException {
		String firstName = readStringValue(br);
		String lastName = readStringValue(br);
		int age = readIntValue(br);
		// TODO: Section A, Task 4
		//       create an economy class passenger using firstName, lastName and age
		Passenger passenger = new EconomyClassPasssenger(firstName, lastName, age);
		//       call allocateInRange with appropriate arguments
		allocateInRange(passenger, LAST_BUSINESS_SEAT.next(), Seat.LAST_SEAT);
	}

	// TODO: Section A, Task 5 - add upgrade method
    public void upgrade() throws AeroplaneFullException {
		for (Seat curr = LAST_BUSINESS_SEAT.next(); curr.hasNext(); curr = curr.next()) {
			if (allocation.containsKey(curr)) {
				Passenger passenger = allocation.remove(curr);
				allocateInRange(passenger, LAST_CREW_SEAT.next(), Seat.LAST_SEAT);
			}
		}
	}

}
