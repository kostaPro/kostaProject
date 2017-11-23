package store;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import domain.Spot;
import store.logic.SpotStoreLogic;

public class SpotStoreLogicTest {
	
	@Autowired
	SpotStore store;
	
	@Test
	public void testCreateSpot() {
		fail("Not yet implemented");
	}

	@Test
	public void testRetrieveAllSpots() {
		fail("Not yet implemented");
	}

	@Test
	public void testRetrieveSpotsByLocation() {
		fail("Not yet implemented");
	}

	@Test
	public void testRetrieveSpotsBySpotType() {
		fail("Not yet implemented");
	}

	@Test
	public void testRetrieveSpotsByLocationSpotType() {
		fail("Not yet implemented");
	}

	@Test
	public void testRetrieveSpotBySpotId() {
		Spot spot = store.retrieveSpotBySpotId(21);
		
		assertEquals(0, spot.getReviewList().size());
		assertEquals(2, spot.getSpotId());
		assertEquals(0, spot.getSpotImageList().size());
	}

	@Test
	public void testRetrieveSpotsBySpotName() {
		fail("Not yet implemented");
	}

	@Test
	public void testRetrieveImageListBySpotId() {
		List<String> imageList = new ArrayList<>();
		imageList = store.retrieveImageListBySpotId(22);
		
		assertEquals(2, imageList.size());
	}

	@Test
	public void testRetrieveSpotsByRegisterId() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateSpot() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteSpot() {
		fail("Not yet implemented");
	}

	@Test
	public void testCreateSpotImage() {
//		store.createSpotImage(22, "/test/tt.jpg");
	}

}
