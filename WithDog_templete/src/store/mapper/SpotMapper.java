package store.mapper;

import java.util.List;
import java.util.Map;

import domain.Spot;

public interface SpotMapper {
	
	boolean createSpot(Spot spot);
	
	List<Spot> retrieveAllSpots();

	List<Spot> retrieveSpotsByCondition(Map<String, String> map);
	
	Spot retrieveSpotBySpotId(int spotId);
	
	List<String> retrieveImageListBySpotId(int spotId);
	boolean createSpotImage(Map<String,Object> map);
	
	List<Spot> retrieveSpotsByRegisterId(String registerId);
	
	boolean updateSpot(Spot spot);
	
	boolean deleteSpot(int spotId);
}
