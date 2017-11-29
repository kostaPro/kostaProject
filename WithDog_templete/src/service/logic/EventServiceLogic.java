package service.logic;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import domain.Comment;
import domain.Event;
import domain.Spot;
import service.EventService;
import store.CommentStore;
import store.EventStore;
import store.UserStore;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = { "file:WebContent/WEB-INF/dispatcher-servlet.xml" })
@Service
public class EventServiceLogic implements EventService {

	@Autowired
	private EventStore eventStore;
	@Autowired
	private CommentStore commentStore;
	@Autowired
	private UserStore userStore;

//	@Test
//	public void test() {
//
//		Spot spot = new Spot();
//		spot.setSpotId(1);
//
//		String oDate = "2017-12-25";
//		Date oepnDate = null;
//		String cDate = "2017-12-25";
//		Date closeDate = null;
//
//		try {
//			oepnDate = new SimpleDateFormat("yyyy-MM-dd").parse(oDate);
//			closeDate = new SimpleDateFormat("yyyy-MM-dd").parse(cDate);
//
//			Event event = new Event();
//			event.setEventName("testName7");
//			event.setEventSpot(spot);
//			event.setEventImage("27");
//			event.setOpenDate(oepnDate);
//			event.setCloseDate(closeDate);
//			event.setEventInfo("127");
//
//			registEvent(event);
//
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
//
//	}

	@Override
	public boolean registEvent(Event event) {

		return eventStore.createEvent(event);
	}

	@Override
	public List<Event> findAllEvents() {

		return eventStore.retrieveAllEvents();
	}

	@Override
	public List<Event> findEventsByDate(Date date) {

		return eventStore.retrieveEventsByDate(date);
	}

	@Override
	public List<Event> findEventsByLocation(String location) {

		return eventStore.retrieveEventsByLocation(location);
	}

	@Override
	public List<Event> findEventsByDateLocation(Date date, String location) {

		return eventStore.retrieveEventsByDateLocation(date, location);
	}

	@Override
	public Event findEventByEventId(int eventId) {

		return eventStore.retrieveEventByEventId(eventId);
	}

	@Override
	public boolean joinEventMeeting(int eventId, String guestId, Date date) {

		return eventStore.joinEventMeeting(eventId, guestId, date);
	}

	@Override
	public boolean cancelEventMeeting(int eventId, String guestId, Date date) {

		return eventStore.cancelEventMeeting(eventId, guestId, date);
	}

	@Override
	public boolean modifyEvent(Event event) {

		return eventStore.updateEvent(event);
	}

	@Override
	public boolean removeEvent(int eventId) {

		boolean result = false;

		result = eventStore.deleteEvent(eventId);
		if (result) {
			List<Comment> commentList = commentStore.retrieveCommentsByEventId(eventId);

			for (Comment comment : commentList) {
				commentStore.deleteEventCommentList(comment.getCommentId());

			}
		}

		return result;
	}

}
