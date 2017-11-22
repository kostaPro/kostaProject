package store;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import domain.Spot;
import store.logic.SpotStoreLogic;

public class SpotStoreLogicTest {

	SpotStore store;
	
	@Before
	public void setUp() {
		store = new SpotStoreLogic();
	}
	
//	@Test
//	public void testCreateSpot() {
//		Spot spot = new Spot();
//		
//		spot.setRegisterId("test");
//		spot.setSpotType("cafe");
//		spot.setSpotInfo("this place for All kinda of pet");
//		spot.setSpotLocation("인천");
//		spot.setSpotName("bowWow");
//		spot.setThumbnail("url/dfsfds/dfsdf");
//		
//		store.createSpot(spot);
//	}

	@Test
	public void testRetrieveAllSpots() {
		fail("Not yet implemented");
	}

	@Test
	public void testRetrieveEventSpot() {
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
		fail("Not yet implemented");
	}

	@Test
	public void testRetrieveSpotsBySpotName() {
		fail("Not yet implemented");
	}

	@Test
	public void testRetrieveImageListBySpotId() {
		fail("Not yet implemented");
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

}
