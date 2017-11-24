package store.logic;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import domain.Event;
import store.EventStore;
import store.factory.SqlSessionFactoryProvider;
import store.mapper.EventMapper;

@Repository
public class EventStoreLogic implements EventStore{
	
	private SqlSessionFactory factory;

	public EventStoreLogic() {
		factory = SqlSessionFactoryProvider.getSqlSessionFactory();
	}

	@Override
	public boolean createEvent(Event event) {

		SqlSession session = factory.openSession();
		boolean result = false;
		
		try {
			EventMapper mapper = session.getMapper(EventMapper.class);
			result = mapper.createEvent(event);
			
			if(result) {
				session.commit();
			} else {
				session.rollback();
			}
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			session.close();
		}

		return result;
	}

	@Override
	public List<Event> retrieveAllEvents() {

		SqlSession session = factory.openSession();
		List<Event> list = null;

		try {
			EventMapper mapper = session.getMapper(EventMapper.class);			
			list = mapper.retrieveAllEvents();
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			session.close();
		}

		return list;
	}

	@Override
	public List<Event> retrieveEventsByDate(Date date) {

		SqlSession session = factory.openSession();
		List<Event> list = null;

		try {
			EventMapper mapper = session.getMapper(EventMapper.class);
			list = mapper.retrieveEventsByDate(date);
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			session.close();
		}

		return list;
	}

	@Override
	public List<Event> retrieveEventsByLocation(String location) { //location

		SqlSession session = factory.openSession();
		List<Event> list = null;

		try {
			EventMapper mapper = session.getMapper(EventMapper.class);
			list = mapper.retrieveEventsByLocation(location);
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			session.close();
		}

		return list;
	}

	@Override
	public List<Event> retrieveEventsByDateLocation(Date date, String location) { //loctaion

		SqlSession session = factory.openSession();
		List<Event> events = null;
		Map<String,Object> map = new HashMap<>();

		try {
			EventMapper mapper = session.getMapper(EventMapper.class);
			
			map.put("date", date);
			map.put("location", location);
			
			events = mapper.retrieveEventsByDateLocation(map);
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			session.close();
		}

		return events;
	}

	@Override
	public Event retrieveEventByEventId(int eventId) {

		SqlSession session = factory.openSession();
		Event event = null;

		try {
			EventMapper mapper = session.getMapper(EventMapper.class);
			event = mapper.retrieveEventByEventId(eventId);
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			session.close();
		}

		return event;
	}

	@Override
	public List<String> retrieveJoinListByEventDate(int eventId, Date eventDate) {

		SqlSession session = factory.openSession();
		List<String> joinList = null;
		Map<String, Object> map = new HashMap<>();

		try {
			EventMapper mapper = session.getMapper(EventMapper.class);
			
			map.put("eventId", eventId);
			map.put("eventDate", eventDate);
			
			joinList = mapper.retrieveJoinListByEventDate(map);
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			session.close();
		}

		return joinList;
	}

	@Override
	public boolean joinEventMeeting(int eventId, String guestId, Date date) {

		SqlSession session = factory.openSession();
		boolean result;
		Map<String, Object> map = new HashMap<>();

		try {
			EventMapper mapper = session.getMapper(EventMapper.class);
			
			map.put("eventId", eventId);
			map.put("guestId", guestId);
			map.put("date", date);
			
			result = mapper.joinEventMeeting(map);
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			session.close();
		}

		return result;
	}

	@Override
	public boolean cancelEventMeeting(int eventId, String guestId, Date date) {

		SqlSession session = factory.openSession();
		boolean result;
		Map<String, Object> map = new HashMap<>();

		try {
			EventMapper mapper = session.getMapper(EventMapper.class);
			
			map.put("eventId", eventId);
			map.put("guestId", guestId);
			map.put("date", date);
			
			result = mapper.cancelEventMeeting(map);
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			session.close();
		}

		return result;
	}

	@Override
	public boolean cancelAllEventMeeting(int eventId) { //event 강제 취소시

		SqlSession session = factory.openSession();
		boolean result;

		try {
			EventMapper mapper = session.getMapper(EventMapper.class);
			result = mapper.cancelAllEventMeeting(eventId);
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			session.close();
		}

		return result;
	}

	@Override
	public boolean updateEvent(Event event) {

		SqlSession session = factory.openSession();
		boolean result;

		try {
			EventMapper mapper = session.getMapper(EventMapper.class);
			result = mapper.updateEvent(event);
			
			if(result) {
				session.commit();
			}
			else {
				session.rollback();
			}
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			session.close();
		}

		return result;
	}

	@Override
	public boolean deleteEvent(int eventId) {

		SqlSession session = factory.openSession();
		boolean result;
		
		try {
			EventMapper mapper = session.getMapper(EventMapper.class);
			result = mapper.deleteEvent(eventId);
			
			if(result) {
				session.commit();
			}
			else {
				session.rollback();
			}
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			session.close();
		}

		return result;
	}
	
}
