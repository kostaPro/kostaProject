package service.logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import domain.Spot;
import service.SpotService;
import store.CommentStore;
import store.ReviewStore;
import store.SpotStore;

@Service
public class SpotServiceLogic implements SpotService{
	
	@Autowired
	private SpotStore spotStore;
	@Autowired
	private ReviewStore reviewStore;
	@Autowired
	private CommentStore commentStore;

	@Override
	public boolean registSpot(Spot spot) {
		
		return false;
	}

	@Override
	public List<Spot> findAllSpots() {
		
		return null;
	}

	@Override
	public List<Spot> findSpotsByLocation(String location) {
		
		return null;
	}

	@Override
	public List<Spot> findSpotsBySpotType(String spotType) {
		
		return null;
	}

	@Override
	public List<Spot> findSpotsByLocationSpotType(String location, String spotType) {
	
		return null;
	}

	@Override
	public Spot findSpotBySpotId(int spotId) {
		
		return null;
	}

	@Override
	public List<Spot> findSpotsByRegisterId(String registerId) {
		
		return null;
	}

	@Override
	public List<Spot> findSpotsBySpotName(String spotName) {
		
		return null;
	}

	@Override
	public boolean modifySpot(Spot spot) {
	
		return false;
	}

	@Override
	public boolean removeSpot(int spotId) {
		
		return false;
	}

}
