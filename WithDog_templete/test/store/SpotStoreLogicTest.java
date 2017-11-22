package store;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
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
	
<<<<<<< HEAD
	@Test
	public void testCreateSpot() {
//		Spot spot = new Spot();
//		
//		spot.setRegisterId("test");
//		spot.setSpotType("cafe");
//		spot.setSpotInfo("this place for All kinda of pet");
//		spot.setSpotLocation("인천");
//		spot.setSpotName("bow");
//		spot.setThumbnail("url/dfsfds/dfsdf");
//		
//		store.createSpot(spot);
	}
=======
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
>>>>>>> refs/remotes/origin/master

	@Test
	public void testRetrieveAllSpots() {
//		List<Spot> spotList = null;
//		
//		spotList = store.retrieveAllSpots();
//		
//		assertEquals(1, spotList.size());
//		assertEquals(1, spotList.get(0).getSpotName());
		
	}


	@Test
	public void testRetrieveSpotsByLocation() {
		List<Spot> spotList = null;
		
		spotList = store.retrieveSpotsByLocation("인천");
		assertEquals(1, spotList.size());
		assertEquals("bow", spotList.get(0).getSpotName());
	}

	@Test
	public void testRetrieveSpotsBySpotType() {
		List<Spot> spotList = null;
		
		spotList = store.retrieveSpotsBySpotType("pool");
		assertEquals(0, spotList.size());
		assertEquals("bow", spotList.get(0).getSpotName());
	}

	@Test
	public void testRetrieveSpotsByLocationSpotType() {
		List<Spot> spotList = null;
		
		spotList = store.retrieveSpotsByLocationSpotType("수원", "cafe");
		assertEquals(1, spotList.size());
		assertEquals("bow", spotList.get(0).getSpotName());
	}

	@Test
	public void testRetrieveSpotBySpotId() {
		Spot spot = store.retrieveSpotBySpotId(1);
		assertEquals("bowWow", spot.getSpotName());
	}

	@Test
	public void testRetrieveSpotsBySpotName() {
		List<Spot> spotList = null;
		
		spotList = store.retrieveSpotsBySpotName("bow");
		assertEquals(3, spotList.size());
		assertEquals("bow", spotList.get(0).getSpotName());
	}

	@Test
	public void testRegistSpotImage() {
		store.createSpotImage(12, "/test/tt.jpg");

	}
	
	@Test
	public void testRetrieveImageListBySpotId() {
		

	}

	@Test
	public void testRetrieveSpotsByRegisterId() {
		List<Spot> spotList = null;
		
		spotList = store.retrieveSpotsByRegisterId("tt");
		assertEquals(1, spotList.size());
		assertEquals("bowWow", spotList.get(0).getSpotName());
	}

	@Test
	public void testUpdateSpot() {
		Spot spot = store.retrieveSpotBySpotId(1);
		spot.setSpotInfo("changeeee");
		spot.setSpotType("park");
		store.updateSpot(spot);
	}

	@Test
	public void testDeleteSpot() {
//		store.deleteSpot(22);
	}

}
