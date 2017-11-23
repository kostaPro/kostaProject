package service;

import java.util.List;

import domain.Spot;

public interface SpotService {
	
	boolean registSpot(Spot spot);
	boolean registSpotImage(int spotId, String imageUrl);
	
	List<Spot> findAllSpots();
	List<Spot> findSpotsByLocation(String location);
	List<Spot> findSpotsBySpotType(String spotType);
	List<Spot> findSpotsByLocationSpotType(String location, String spotType);
	Spot findSpotBySpotId(int spotId);
	List<Spot> findSpotsByRegisterId(String registerId);
	List<Spot> findSpotsBySpotName(String spotName);
	boolean modifySpot(Spot spot);
	boolean removeSpot(int spotId);

}
