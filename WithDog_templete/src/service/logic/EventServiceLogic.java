package service.logic;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import domain.Comment;
import domain.Event;
import domain.Spot;
import domain.User;
import service.EventService;
import store.CommentStore;
import store.EventStore;
import store.UserStore;

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

		// Date to String
		Date openDate = event.getOpenDate();
		Date closeDate = event.getCloseDate();

		SimpleDateFormat transFormat = new SimpleDateFormat("yyyyMMdd");

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
			} catch (ParseException e) {
				// TODO Auto-generated catch block
			}
			
			java.sql.Date eventDate = new java.sql.Date(eventDateForm.getTime());
			
			userIdList = eventStore.retrieveJoinListByEventDate(eventId, eventDate);
			
			if(userIdList != null ) {
				if( userIdList.size() != 0) {
					users = userStore.retrieveUserList(userIdList);
				}
			}
			int year = i/10000;
			int month = ( i % 10000 ) / 100;
			int day = ( i % 100 );

			String joinDate = String.valueOf(year) + "-" + String.valueOf(month) + "-" + String.valueOf(day);
			eventJoinFullList.put(joinDate, users);
		}

		event.setEventJoinLists(eventJoinFullList);
		event.setCommentList(findCommentByEventId(eventId));
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
	
	@Override
	public List<Comment> findCommentByEventId(int eventId) {
		List<Comment> eventCommentList = commentStore.retrieveCommentsByEventId(eventId);
		
		//부모
		List<Comment> eventCommentListParent = new ArrayList<Comment>();
		//자식
		List<Comment> eventCommentListChild = new ArrayList<Comment>();
		//통합
		List<Comment> newEventCommentList = new ArrayList<Comment>();
		
		//부모 자식 분리
		for(Comment comment : eventCommentList) {
			if(comment.getDepth().equals("0")) {
				eventCommentListParent.add(comment);
			}else {
				eventCommentListChild.add(comment);
			}
		}
		//로직
		for(Comment eventCommentParent : eventCommentListParent) {
			newEventCommentList.add(eventCommentParent);
			for(Comment eventCommentChild : eventCommentListChild) {
				String commentId = String.valueOf(eventCommentParent.getCommentId());
				if(commentId.equals(eventCommentChild.getParentId())) {
					newEventCommentList.add(eventCommentChild);
				}
			}
		}
		return newEventCommentList;
	}

}
