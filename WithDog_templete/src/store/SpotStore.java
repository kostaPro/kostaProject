package store;

import java.util.List;

import domain.Spot;

public interface SpotStore {
	
	boolean createSpot(Spot spot);
	boolean createEventSpot(Spot spot);
	List<Spot> retrieveAllSpots();
	Spot retrieveEventSpot(int eventId);
	List<Spot> retrieveSpotsByLocation(String location);
	List<Spot> retrieveSpotsBySpotType(String spotType);
	List<Spot> retrieveSpotsByLocationSpotType(String location, String spotType);
	Spot retrieveSpotBySpotId(int spotId);
	List<Spot> retrieveSpotsBySpotName(String spotName);
	List<String> retrieveImageListBySpotId(int spotId);
	List<Spot> retrieveSpotsByRegisterId(String registerId);
	boolean updateSpot(Spot spot);
	boolean updateEventSpot(Spot spot);
	boolean deleteSpot(int spotId);
	boolean deleteEventSpot(int eventId);
}
