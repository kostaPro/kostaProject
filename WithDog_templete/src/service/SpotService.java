package service;

import java.util.List;

import domain.Spot;

public interface SpotService {
	
	boolean registSpot(Spot spot);
	boolean registSpotImage(int spotId, String imageUrl);
	
	List<Spot> findAllSpots();

	List<Spot> findSpotsByCondition(String spotLocation, String spotType,String spotName);
	
	Spot findSpotBySpotId(int spotId);
	List<Spot> findSpotsByRegisterId(String registerId);
	boolean modifySpot(Spot spot);
	boolean removeSpot(int spotId);

}
