package service.logic;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import domain.Event;
import service.EventService;
import store.CommentStore;
import store.EventStore;
import store.UserStore;

@Service
public class EventServiceLogic implements EventService{
	
	@Autowired
	private EventStore eventStore;
	@Autowired
	private CommentStore commentStore;
	@Autowired
	private UserStore userStore;

	@Override
	public boolean registEvent(Event event) {
		
		return false;
	}

	@Override
	public List<Event> findAllEvents() {
	
		return null;
	}

	@Override
	public List<Event> findEventsByDate(Date date) {
		
		return null;
	}

	@Override
	public List<Event> findEventsByLocation(String location) {
		
		return null;
	}

	@Override
	public List<Event> findEventsByDateLocation(Date date, String location) {
		
		return null;
	}

	@Override
	public Event findEventByEventId(int eventId) {
		
		return null;
	}

	@Override
	public boolean joinEventMeeting(int meetingId, String guestId, Date date) {
		
		return false;
	}

	@Override
	public boolean cancelEventMeeting(int meetingId, String guestId, Date date) {
		
		return false;
	}

	@Override
	public boolean modifyEvent(Event event) {
		
		return false;
	}

	@Override
	public boolean removeEvent(int eventId) {
		
		return false;
	}

}
