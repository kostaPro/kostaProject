package store;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import domain.Event;
import domain.User;
import store.logic.EventStoreLogic;
import store.logic.UserStoreLogic;

public class EventStoreLogicTest {
	
	private EventStore store;
	private UserStore userStore;
	
	@Before
	public void setUp() {
		store = new EventStoreLogic();
		userStore = new UserStoreLogic();
	}

	@Test
	public void testCreateEvent() {
		fail("Not yet implemented");
	}

	@Test
	public void testRetrieveAllEvents() {
		fail("Not yet implemented");
	}

	@Test
	public void testRetrieveEventsByDate() {
		fail("Not yet implemented");
	}

	@Test
	public void testRetrieveEventsByLocation() {
		fail("Not yet implemented");
	}

	@Test
	public void testRetrieveEventsByDateLocation() {
		fail("Not yet implemented");
	}

	@Test
	public void testRetrieveEventByEventId() {
		fail("Not yet implemented");
	}

	@Test
	public void testRetrieveJoinListByEventDate() {

		Event event = store.retrieveEventByEventId(2);

		// Date to String
		Date openDate = event.getOpenDate();
		Date closeDate = event.getCloseDate();

		SimpleDateFormat transFormat = new SimpleDateFormat("yyMMdd");

		int start = Integer.parseInt(transFormat.format(openDate));
		int end = Integer.parseInt(transFormat.format(closeDate));

		Map<String, List<User>> eventJoinFullList = new HashMap<>();

		// 참여목록 만드는 for문
		for (int i = start; i < (end + 1 ); i++) {

			Date eventDateForm = null;
			List<String> userIdList = null;
			List<User> users = null;
			
			try {
				eventDateForm = transFormat.parse(String.valueOf(i));
				System.out.println("DateForm : " + eventDateForm);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
			}
			
			java.sql.Date eventDate = new java.sql.Date(eventDateForm.getTime());
			
			userIdList = store.retrieveJoinListByEventDate(2, eventDate);
			
			if(userIdList != null ) {
				if( userIdList.size() != 0) {
					users = userStore.retrieveUserList(userIdList);
				}
			}
			
			eventJoinFullList.put(String.valueOf(i), users);
		}

	}

	@Test
	public void testJoinEventMeeting() {
		fail("Not yet implemented");
	}

	@Test
	public void testCancelEventMeeting() {
		fail("Not yet implemented");
	}

	@Test
	public void testCancelAllEventMeeting() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateEvent() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteEvent() {
		fail("Not yet implemented");
	}

}
