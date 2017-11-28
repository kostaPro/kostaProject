package store;

import java.util.List;
import java.util.Map;

import domain.Spot;

public interface SpotStore {
	
	boolean createSpot(Spot spot);

	List<Spot> retrieveAllSpots();

	List<Spot> retriveSpotsByCondition(String spotLocation, String spotType, String spotName);
	
	Spot retrieveSpotBySpotId(int spotId);
	
	List<String> retrieveImageListBySpotId(int spotId);
	boolean createSpotImage(int spotId, String imageUrl);
	
	List<Spot> retrieveSpotsByRegisterId(String registerId);
	
	boolean updateSpot(Spot spot);
	
	boolean deleteSpot(int spotId);
	
}
