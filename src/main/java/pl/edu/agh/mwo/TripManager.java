package pl.edu.agh.mwo;
import java.util.*;

public class TripManager {
	private HashMap<String,Trip> tripList;
	
	public TripManager() {
		tripList = new HashMap<String,Trip>();
	}
	
	public void add(Trip trip) throws TripAlreadyExistsException {
		if (tripList.get(trip.getName()) != null) {
			throw new TripAlreadyExistsException();
		}
		else {
			tripList.put(trip.getName(),trip);
		}
	}
	
	public HashMap<String,Trip> getTrips() {
		return tripList;
	}

	public void remove(String name) {
		tripList.remove(name);
	}

public Map<String,Trip> findTrip(String keyword){
	HashMap<String, Trip> foundTrips=new HashMap();
	if(keyword=="") {
			foundTrips=tripList;
	}
	for (String nametrip : tripList.keySet()) {
        if (nametrip.contains(keyword))
            foundTrips.put(nametrip,tripList.get(nametrip));
	
	else if (tripList.get(nametrip).getDescription().contains(keyword)) {
		foundTrips.put(nametrip,tripList.get(nametrip));
	} else {
		List<Photo> photos = tripList.get(nametrip).getPhotos();
		for (Photo photo : photos) {
			if (photo.getComment().contains(keyword)) {
				foundTrips.put(nametrip,tripList.get(nametrip));;
			}
		}
	}
}
	return foundTrips;
	
		
}
}
