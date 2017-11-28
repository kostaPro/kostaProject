package service.logic;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import domain.Review;
import domain.Spot;
import service.SpotService;
import store.CommentStore;
import store.ReviewStore;
import store.SpotStore;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"file:WebContent/WEB-INF/dispatcher-servlet.xml"})
@Service
public class SpotServiceLogic implements SpotService{
	
	@Autowired
	private SpotStore spotStore;
	@Autowired
	private ReviewStore reviewStore;
	@Autowired
	private CommentStore commentStore;

	@Test
	public void test() {
		Spot spot = new Spot();
		spot.setSpotName("testetet");
		spot.setRegisterId("dd");
		spot.setSpotInfo("tt");
		spot.setSpotLocation("aa");
		spot.setSpotType("vv");
		spot.setThumbnail("sdfsdf");
		registSpot(spot);
		
//		removeSpot(1);
		
	}
	
	@Override
	public boolean registSpot(Spot spot) {
		
		return spotStore.createSpot(spot);
	}

	@Override
	public List<Spot> findAllSpots() {
		
		return spotStore.retrieveAllSpots();
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

	@Override
	public List<Spot> findSpotsByCondition(String spotLocation, String spotType, String spotName) {
		
		return spotStore.retriveSpotsByCondition(spotLocation, spotType, spotName);
	}

}
