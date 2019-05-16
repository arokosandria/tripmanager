package pl.edu.agh.mwo;
import static org.junit.Assert.*;

import java.util.Map;

import org.junit.Before;
import org.junit.Test;

public class TripManagerTest {

	TripManager tripManager;
	Trip trip, trip1, trip2, trip3;
	Photo photo;
	
	@Before
	public void setUp() {
		tripManager = new TripManager();
		trip = new Trip("nazwa", "opis");
		trip1 = new Trip("ekstra nazwa wycieczki", "Teneryfa Last Minute");
		trip2 = new Trip("Super nazwa wycieczki", "Egipt all incusive");
		trip3 = new Trip("Extra promocja", "Tunezja");
		photo=new Photo("piekne wybrzeze");
		trip3.addPhoto(photo);
	}
	
	@Test
	public void testAdd() throws TripAlreadyExistsException {
		assertEquals(0, tripManager.getTrips().size());
		tripManager.add(trip);
		assertEquals(1, tripManager.getTrips().size());
	}

	@Test(expected = TripAlreadyExistsException.class)
	public void testAddTripTwice() throws TripAlreadyExistsException {
		assertEquals(0, tripManager.getTrips().size());
		tripManager.add(trip);
		assertEquals(1, tripManager.getTrips().size());
		tripManager.add(trip);
	}

	@Test
	public void testRemoveTrip() throws Exception {
		tripManager.add(trip);
		assertEquals(1, tripManager.getTrips().size());
		tripManager.remove(trip.getName());
		assertEquals(0, tripManager.getTrips().size());
		//fail("chcemy zespuc");
		}
	@Test
    public void testFindTripIsNull() throws TripAlreadyExistsException {
        tripManager.add(trip);
        tripManager.add(trip1);
        tripManager.add(trip2);
        tripManager.add(trip3);
        assertEquals(4,tripManager.findTrip("").size());
}
	@Test
	public void testFindTripName() throws TripAlreadyExistsException {
		tripManager.add(trip1);
		tripManager.add(trip2);
		assertEquals(2, tripManager.findTrip("wycieczki").size());
	}

	@Test
	public void testFindDesctiption() throws TripAlreadyExistsException {
		tripManager.add(trip3);
		assertEquals(1, tripManager.findTrip("Tunezja").size());
	}

	@Test
	public void testFindPhoto() throws TripAlreadyExistsException {
		tripManager.add(trip3);
		assertEquals(1, tripManager.findTrip("piekne wybrzeze").size());
}
}
