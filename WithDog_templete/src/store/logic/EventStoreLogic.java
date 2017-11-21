package store.logic;

import java.sql.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import domain.Event;
import store.EventStore;
import store.factory.SqlSessionFactoryProvider;

@Repository
public class EventStoreLogic implements EventStore{
	
	private SqlSessionFactory factory;

	public EventStoreLogic() {
		factory = SqlSessionFactoryProvider.getSqlSessionFactory();
	}

	@Override
	public boolean createEvent(Event event) {

		SqlSession session = factory.openSession();

		try {

		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			session.close();
		}

		return false;
	}

	@Override
	public List<Event> retrieveAllEvents() {

		SqlSession session = factory.openSession();

		try {

		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			session.close();
		}

		return null;
	}

	@Override
	public List<Event> retrieveEventsByDate(Date date) {

		SqlSession session = factory.openSession();

		try {

		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			session.close();
		}

		return null;
	}

	@Override
	public List<Event> retrieveEventsByLocation(String location) {

		SqlSession session = factory.openSession();

		try {

		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			session.close();
		}

		return null;
	}

	@Override
	public List<Event> retrieveEventsByDateLocation(Date date, String location) {

		SqlSession session = factory.openSession();

		try {

		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			session.close();
		}

		return null;
	}

	@Override
	public Event retrieveEventByEventId(int eventId) {

		SqlSession session = factory.openSession();

		try {

		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			session.close();
		}

		return null;
	}

	@Override
	public List<String> retrieveJoinListByEventDate(int eventId, Date eventDate) {

		SqlSession session = factory.openSession();

		try {

		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			session.close();
		}

		return null;
	}

	@Override
	public boolean joinEventMeeting(int eventId, String guestId, Date date) {

		SqlSession session = factory.openSession();

		try {

		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			session.close();
		}

		return false;
	}

	@Override
	public boolean cancelEventMeeting(int evnetId, String guestId, Date date) {

		SqlSession session = factory.openSession();

		try {

		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			session.close();
		}

		return false;
	}

	@Override
	public boolean cancelAllEventMeeting(int eventId) {

		SqlSession session = factory.openSession();

		try {

		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			session.close();
		}

		return false;
	}

	@Override
	public boolean updateEvent(Event event) {

		SqlSession session = factory.openSession();

		try {

		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			session.close();
		}

		return false;
	}

	@Override
	public boolean deleteEvent(int eventId) {

		SqlSession session = factory.openSession();

		try {

		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			session.close();
		}

		return false;
	}
	
}
