package service.logic;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import domain.User;
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

		Event event = eventStore.retrieveEventByEventId(eventId);
		// openDate와 closeDate사이의 날 차이
		// long diffDay = (closeDate.getTime() - openDate.getTime()) / (24 * 60 * 60 *
		// 1000);
		// int p = (int)(diffDay);

		// Date to String
		Date openDate = event.getOpenDate();
		Date closeDate = event.getCloseDate();

		SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd");

		String start = transFormat.format(openDate);
		String end = transFormat.format(closeDate);

		// 년,월, 일 쪼개기
		String[] arrayStart;
		arrayStart = start.split("-");

		String[] arrayEnd;
		arrayEnd = end.split("-");

		// 일만 String으로 추출
		String open = arrayStart[2];
		String close = arrayEnd[2];

		// String to int
		int openDay = Integer.parseInt(open);
		int closeDay = Integer.parseInt(close);

		Map<String, List<User>> eventJoinLists = new HashMap<>();

		// 참여목록 만드는 for문
		for (int i = 0; i < (closeDay - openDay) + 1; i++) {

			Date eventDate = openDate;

			List<String> userIdList = eventStore.retrieveJoinListByEventDate(eventId, eventDate);
			List<User> users = userStore.retrieveUserList(userIdList);

			eventJoinLists.put(String.valueOf(i), users);

		}

		System.out.println(eventJoinLists.size());

		return event;
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
