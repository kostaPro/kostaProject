package store;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
	
	
	@Test
	public void testCreateMeeting() {
		Meeting meeting = new Meeting();
		Spot spot = new Spot();
		spot.setSpotId(2);
		
		String d = "2017-01-01";
		Date date = null;
		try {
			date = new SimpleDateFormat("yyyy-MM-dd").parse(d);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		meeting.setMeetingDate(date);
		meeting.setMeetingTime(7);
		meeting.setMeetingSpot(spot);
		meeting.setMinPerson(7);
		meeting.setHostId("Hoon");
		meeting.setMeetingPurpose("안녕~~~~~~~~!");
		
		store.createMeeting(meeting);
	}

//	@Test
//	public void testRetrieveAllMeetings() {
//		List<Meeting> meetings = store.retrieveAllMeetings();
//		
//		assertEquals(2, meetings.size());
//	}

//	@Test
//	public void testRetrieveMeetingsByLocation() {
//	
//		List<Meeting> meetings = store.retrieveMeetingsByLocation("여의도역");
//
//		assertEquals(7, meetings.get(0).getMeetingTime());
//	}

//	@Test
//	public void testRetrieveMeetingsByDate() {
//		String d = "2017-01-01";
//		Date date = null;
//		try {
//			date = new SimpleDateFormat("yyyy-MM-dd").parse(d);
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
//		
//		List<Meeting> meetings = store.retrieveMeetingsByDate(date);
//		
//		assertEquals("안녕~~~~~~~~!", meetings.get(0).getMeetingPurpose());
//		
//	}

//	@Test
//	public void testRetrieveMeetingsByLocationDate() {
//		String d = "2017-01-01";
//		Date date = null;
//		try {
//			date = new SimpleDateFormat("yyyy-MM-dd").parse(d);
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
//		
//		
//		List<Meeting> meetings = store.retrieveMeetingsByLocationDate("전주", date);
//		
//		assertEquals(7, meetings.get(0).getMeetingTime());
//		
//	}

//	@Test
//	public void testRetrieveMeetingsByGuest() {
//		List<Meeting> list = store.retrieveMeetingsByGuest("uraid");
//		
//		assertEquals(2, list.size());
//	}

//	@Test
//	public void testRetrieveMeetingsByHost() {
//		List<Meeting> list = store.retrieveMeetingsByHost("Hoon");
//		
//		assertEquals(33, list.size());
//	}

	@Test
	public void testRetrieveMeetingByMeetingId() {
		Meeting meeting = store.retrieveMeetingByMeetingId(10);
		
		
		assertEquals("Hoon",meeting.getHostId());
		assertEquals(2, meeting.getMeetingImageList().size());
		assertEquals(3, meeting.getCommentList().size());
	}
//
//	@Test
//	public void testRetrieveJoinListByMeetingId() {
//		List<String> list = store.retrieveJoinListByMeetingId(10);
//		
//		assertEquals(2, list.size());
//	}

//	@Test
//	public void testcreateMeetingImage() {
//		store.createMeetingImage("www.", 10);
//	}
	
//	@Test
//	public void testRetrieveImageListByMeetingId() {
//		List<String> list = store.retrieveImageListByMeetingId(1);
//		
//		assertEquals(3, list.size());
//	}

//	@Test
//	public void testJoinMeeting() {
//		store.joinMeeting(9, "uraid");
//	}

//	@Test
//	public void testCancelMeeting() {
//		store.cancelMeeting(9, "uraid");
//	}

//	@Test
//	public void testCancelAllJoinList() {
//		store.cancelAllJoinList(10);
//	}

//	@Test
//	public void testUpdateMeeting() {
//		Meeting meeting = store.retrieveMeetingByMeetingId(10);
//		
//		String d = "2017-11-25";
//		Date date = null;
//		try {
//			date = new SimpleDateFormat("yyyy-MM-dd").parse(d);
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
//		
//		
//		meeting.setMeetingDate(date);
//		meeting.setMeetingTime(3);
//		meeting.setSpotId(7);
//		meeting.setMinPerson(2);
//		meeting.setHostId("Hoon");
//		meeting.setMeetingPurpose("퇴근할래요!");
//		
//		store.updateMeeting(meeting);
//		
//	}

//	@Test
//	public void testDeleteMeeting() {
//		store.deleteMeeting(11);
//	}

}
