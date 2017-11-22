package store.mapper;

import java.util.List;
import java.util.Map;

import domain.Spot;

public interface SpotMapper {
	
	boolean createSpot(Spot spot);
	
	List<Spot> retrieveAllSpots();
	
	List<Spot> retrieveSpotsByLocation(String location);
	List<Spot> retrieveSpotsBySpotType(String spotType);
	List<Spot> retrieveSpotsByLocationSpotType(Map<String, String> map);
	
	Spot retrieveSpotBySpotId(int spotId);
	
	List<Spot> retrieveSpotsBySpotName(String spotName);
	List<String> retrieveImageListBySpotId(int spotId);
	List<Spot> retrieveSpotsByRegisterId(String registerId);
	
	boolean updateSpot(Spot spot);
	
	boolean deleteSpot(int spotId);
}
