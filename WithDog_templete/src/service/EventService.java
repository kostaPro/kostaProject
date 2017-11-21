package service;

import java.sql.Date;
import java.util.List;

import domain.Event;

public interface EventService {
	
	boolean registEvent(Event event);
	List<Event> findAllEvents();
	List<Event> findEventsByDate(Date date);
	List<Event> findEventsByLocation(String location);
	List<Event> findEventsByDateLocation(Date date, String location);
	Event findEventByEventId(int eventId);
	boolean joinEventMeeting(int meetingId, String guestId, Date date);
	boolean cancelEventMeeting(int meetingId, String guestId, Date date);
	boolean modifyEvent(Event event);
	boolean removeEvent(int eventId);

}
