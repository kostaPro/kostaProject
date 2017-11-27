package store.mapper;


import java.util.Date;
import java.util.List;
import java.util.Map;

import domain.Event;

public interface EventMapper {
	
	boolean createEvent(Event event);
	
	List<Event> retrieveAllEvents();
	List<Event> retrieveEventsByDate(Date date);
	List<Event> retrieveEventsByLocation(String location);
	List<Event> retrieveEventsByDateLocation(Map<String, Object> map);
	
	Event retrieveEventByEventId(int eventId);
	
	List<String> retrieveJoinListByEventDate(Map<String, Object> map);
	
	boolean joinEventMeeting(Map<String, Object> map);
	
	boolean cancelEventMeeting(Map<String, Object> map);
	boolean cancelAllEventMeeting(int eventId);
	
	boolean updateEvent(Event event);
	
	boolean deleteEvent(int eventId);
}
