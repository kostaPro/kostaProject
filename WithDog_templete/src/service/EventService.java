package service;


import java.util.Date;
import java.util.List;

import domain.Comment;
import domain.Event;

public interface EventService {
	
	boolean registEvent(Event event);
	List<Comment> findCommentByEventId(int eventId);
	List<Event> findAllEvents();
	List<Event> findEventsByDate(Date date);
	List<Event> findEventsByLocation(String location);
	List<Event> findEventsByDateLocation(Date date, String location);
	Event findEventByEventId(int eventId);
	boolean joinEventMeeting(int eventId, String guestId, Date date);
	boolean cancelEventMeeting(int eventId, String guestId, Date date);
	boolean modifyEvent(Event event);
	boolean removeEvent(int eventId);

}
