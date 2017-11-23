package service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import domain.Spot;
import service.logic.SpotServiceLogic;

public class SpotServiceLogicTest {
	
	@Autowired
	SpotService service;
	
	@Test
	public void testRegistSpot() {
//		Spot spot = new Spot();
//		
//		spot.setRegisterId("testId");
//		spot.setSpotInfo("this is test spot");
//		spot.setSpotLocation("부산");
//		spot.setSpotName("testingSpot");
//		spot.setSpotType("park");
//		spot.setThumbnail("/test/abc.jpg");
//		
//		service.registSpot(spot);
	}

	@Test
	public void testFindAllSpots() {
		List<Spot> spotList = service.findAllSpots();
		
		assertEquals(1, spotList.size());
	}

	@Test
	public void testFindSpotsByLocation() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindSpotsBySpotType() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindSpotsByLocationSpotType() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindSpotBySpotId() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindSpotsByRegisterId() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindSpotsBySpotName() {
		fail("Not yet implemented");
	}

	@Test
	public void testModifySpot() {
		fail("Not yet implemented");
	}

	@Test
	public void testRemoveSpot() {
		fail("Not yet implemented");
	}

	@Test
	public void testRegistSpotImage() {
		fail("Not yet implemented");
	}

}
