package store;


import java.util.Date;
import java.util.List;

import domain.Event;

public interface EventStore {
	
	boolean createEvent(Event event);
	List<Event> retrieveAllEvents();
	List<Event> retrieveEventsByDate(Date date);
	List<Event> retrieveEventsByLocation(String location);
	List<Event> retrieveEventsByDateLocation(Date date, String location);
	Event retrieveEventByEventId(int eventId);
	List<String> retrieveJoinListByEventDate(int eventId, Date eventDate);
	
	
	
	boolean joinEventMeeting(int eventId, String guestId, Date date);
	boolean cancelEventMeeting(int eventId, String guestId, Date date);
	boolean cancelAllEventMeeting(int eventId);
	boolean updateEvent(Event event);
	boolean deleteEvent(int eventId);

}
