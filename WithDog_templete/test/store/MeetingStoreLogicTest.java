package store;

import static org.junit.Assert.*;

import java.sql.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import domain.Meeting;
import domain.Spot;
import store.logic.MeetingStoreLogic;

public class MeetingStoreLogicTest {
	MeetingStore store;
	SpotStore spotStore;
	
	@Before
	public void setUp() {
		store = new MeetingStoreLogic();
	}
	
	
//	@Test
//	public void testCreateMeeting() {
//		Meeting meeting = new Meeting();
//		Date date = new Date(2017-11-21);
//		
//		meeting.setMeetingDate(date);
//		meeting.setMeetingTime(4);
//		meeting.setSpotId(1);
//		meeting.setMinPerson(2);
//		meeting.setHostId("Hoon");
//		meeting.setMeetingPurpose("안녕");
//		
//		store.createMeeting(meeting);
//	}

	@Test
	public void testRetrieveAllMeetings() {
		List<Meeting> meetings = store.retrieveAllMeetings();
		
		assertEquals(2, meetings.size());
	}

	@Test
	public void testRetrieveMeetingsByLocation() {
	
		List<Meeting> meetings = store.retrieveMeetingsByLocation(spotStore.retrieveSpotBySpotId(1).getSpotName());

		assertEquals(7, meetings.get(0).getMeetingTime());
	}

	@Test
	public void testRetrieveMeetingsByDate() {
		
	}

	@Test
	public void testRetrieveMeetingsByLocationDate() {
	
	}

	@Test
	public void testRetrieveMeetingsByGuest() {
		
	}

	@Test
	public void testRetrieveMeetingsByHost() {
	
	}

	@Test
	public void testRetrieveMeetingByMeetingId() {
	
	}

	@Test
	public void testRetrieveJoinListByMeetingId() {

	}

	@Test
	public void testRetrieveImageListByMeetingId() {
		
	}

	@Test
	public void testJoinMeeting() {
		
	}

	@Test
	public void testCancelMeeting() {
		
	}

	@Test
	public void testCancelAllJoinList() {
		
	}

	@Test
	public void testUpdateMeeting() {
		
	}

	@Test
	public void testDeleteMeeting() {
		
	}

}
