package service.logic;

import java.util.List;

import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import domain.Review;
import domain.Spot;
import service.SpotService;
import store.CommentStore;
import store.ReviewStore;
import store.SpotStore;

@RunWith( JUnit4.class )
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
		
		return spotStore.createSpot(spot);
	}

	@Override
	public List<Spot> findAllSpots() {
		if(spotStore == null) {
			System.out.println("missing store");
			return null;
		}
		return spotStore.retrieveAllSpots();
	}

	@Override
	public List<Spot> findSpotsByLocation(String location) {
		
		return spotStore.retrieveSpotsByLocation(location);
	}

	@Override
	public List<Spot> findSpotsBySpotType(String spotType) {
		
		return spotStore.retrieveSpotsBySpotType(spotType);
	}

	@Override
	public List<Spot> findSpotsByLocationSpotType(String location, String spotType) {
	
		return spotStore.retrieveSpotsByLocationSpotType(location, spotType);
	}

	@Override
	public Spot findSpotBySpotId(int spotId) {
		return spotStore.retrieveSpotBySpotId(spotId);
	}

	@Override
	public List<Spot> findSpotsByRegisterId(String registerId) {
		
		return spotStore.retrieveSpotsByRegisterId(registerId);
	}

	@Override
	public List<Spot> findSpotsBySpotName(String spotName) {
		
		return spotStore.retrieveSpotsBySpotName(spotName);
	}

	@Override
	public boolean modifySpot(Spot spot) {
	
		return spotStore.updateSpot(spot);
	}

	@Override
	public boolean removeSpot(int spotId) {
		boolean result = false;
		
		result = spotStore.deleteSpot(spotId);
		if(result) {
			List<Review> reviewList = reviewStore.retrieveReviewsBySpotId(spotId);
			
			for(Review review : reviewList) {
				reviewStore.deleteReview(review.getReviewId());
				commentStore.deleteReviewCommentList(review.getReviewId());
			}
		}
		
		return result;
	}

	@Override
	public boolean registSpotImage(int spotId, String imageUrl) {
		return spotStore.createSpotImage(spotId, imageUrl);
	}

}
