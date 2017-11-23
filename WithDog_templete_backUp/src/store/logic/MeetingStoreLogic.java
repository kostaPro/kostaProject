package store.logic;

import java.sql.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import domain.Meeting;
import store.MeetingStore;
import store.factory.SqlSessionFactoryProvider;
import store.mapper.MeetingMapper;

@Repository
public class MeetingStoreLogic implements MeetingStore{
	
	private SqlSessionFactory factory;

	public MeetingStoreLogic() {
		factory = SqlSessionFactoryProvider.getSqlSessionFactory();
	}

	@Override
	public boolean createMeeting(Meeting meeting) {

		SqlSession session = factory.openSession();

		try {
			MeetingMapper mapper = session.getMapper(MeetingMapper.class);
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			session.close();
		}

		return false;
	}

	@Override
	public boolean retrieveAllMeetings() {

		SqlSession session = factory.openSession();

		try {
			MeetingMapper mapper = session.getMapper(MeetingMapper.class);
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			session.close();
		}

		return false;
	}

	@Override
	public List<Meeting> retrieveMeetingsByLocation(String loaction) {

		SqlSession session = factory.openSession();

		try {
			MeetingMapper mapper = session.getMapper(MeetingMapper.class);
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			session.close();
		}

		return null;
	}

	@Override
	public List<Meeting> retrieveMeetingsByDate(Date date) {

		SqlSession session = factory.openSession();

		try {
			MeetingMapper mapper = session.getMapper(MeetingMapper.class);
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			session.close();
		}

		return null;
	}

	@Override
	public List<Meeting> retrieveMeetingsByLocationDate(String location, Date date) {

		SqlSession session = factory.openSession();

		try {
			MeetingMapper mapper = session.getMapper(MeetingMapper.class);
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			session.close();
		}

		return null;
	}

	@Override
	public List<Meeting> retrieveMeetingsByGuest(String guestId) {

		SqlSession session = factory.openSession();

		try {
			MeetingMapper mapper = session.getMapper(MeetingMapper.class);
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			session.close();
		}

		return null;
	}

	@Override
	public List<Meeting> retrieveMeetingsByHost(String hostId) {

		SqlSession session = factory.openSession();

		try {
			MeetingMapper mapper = session.getMapper(MeetingMapper.class);
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			session.close();
		}

		return null;
	}

	@Override
	public Meeting retrieveMeetingByMeetingId(int meetingId) {

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
	public List<String> retrieveJoinListByMeetingId(int meetingId) {

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
	public List<String> retrieveImageListByMeetingId(int meetingId) {

		SqlSession session = factory.openSession();

		try {
			MeetingMapper mapper = session.getMapper(MeetingMapper.class);
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			session.close();
		}

		return null;
	}

	@Override
	public boolean joinMeeting(int meetingId, String guestId) {

		SqlSession session = factory.openSession();

		try {
			MeetingMapper mapper = session.getMapper(MeetingMapper.class);
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			session.close();
		}

		return false;
	}

	@Override
	public boolean cancelMeeting(int meetingId, String guestId) {

		SqlSession session = factory.openSession();

		try {
			MeetingMapper mapper = session.getMapper(MeetingMapper.class);
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			session.close();
		}

		return false;
	}

	@Override
	public boolean cancelAllJoinList(int meetingId) {

		SqlSession session = factory.openSession();

		try {
			MeetingMapper mapper = session.getMapper(MeetingMapper.class);
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			session.close();
		}

		return false;
	}

	@Override
	public boolean updateMeeting(Meeting meeting) {

		SqlSession session = factory.openSession();

		try {
			MeetingMapper mapper = session.getMapper(MeetingMapper.class);
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			session.close();
		}

		return false;
	}

	@Override
	public boolean deleteMeeting(int meetingId) {

		SqlSession session = factory.openSession();

		try {
			MeetingMapper mapper = session.getMapper(MeetingMapper.class);
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			session.close();
		}

		return false;
	}

}
