package store.logic;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
		
		boolean result = false;
		
		try {
			MeetingMapper mapper = session.getMapper(MeetingMapper.class);
			result = mapper.createMeeting(meeting);
			if(result) {
				session.commit();
			}else {
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
	public List<Meeting> retrieveAllMeetings() {

		SqlSession session = factory.openSession();
		List<Meeting> meetingList = new ArrayList<>();
		
		try {
			MeetingMapper mapper = session.getMapper(MeetingMapper.class);
			
			meetingList = mapper.retrieveAllMeetings();
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			session.close();
		}

		return meetingList;
	}

	@Override
	public List<Meeting> retrieveMeetingsByLocation(String loaction) {

		SqlSession session = factory.openSession();
		List<Meeting> meetingList = new ArrayList<>();
		
		try {
			MeetingMapper mapper = session.getMapper(MeetingMapper.class);
			meetingList = mapper.retrieveMeetingsByLocation(loaction);
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			session.close();
		}

		return meetingList;
	}

	@Override
	public List<Meeting> retrieveMeetingsByDate(Date date) {

		SqlSession session = factory.openSession();
		List<Meeting> meetingList = new ArrayList<>();
		try {
			MeetingMapper mapper = session.getMapper(MeetingMapper.class);
			meetingList = mapper.retrieveMeetingsByDate(date);
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			session.close();
		}

		return meetingList;
	}

	@Override
	public List<Meeting> retrieveMeetingsByLocationDate(String location, Date date) {

		SqlSession session = factory.openSession();
		List<Meeting> meetingList = new ArrayList<>();
		Map<String, Object> map = new HashMap<>();

		try {
			MeetingMapper mapper = session.getMapper(MeetingMapper.class);
			map.put("location", location);
			map.put("date", date);
			
			meetingList = mapper.retrieveMeetingsByLocationDate(map);
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			session.close();
		}

		return meetingList;
	}

	@Override
	public List<Meeting> retrieveMeetingsByGuest(String guestId) {

		SqlSession session = factory.openSession();
		List<Meeting> meetingList = new ArrayList<>();
		try {
			MeetingMapper mapper = session.getMapper(MeetingMapper.class);
			meetingList = mapper.retrieveMeetingsByGuest(guestId);
		
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			session.close();
		}

		return meetingList;
	}

	@Override
	public List<Meeting> retrieveMeetingsByHost(String hostId) {

		SqlSession session = factory.openSession();
		List<Meeting> meetingList = new ArrayList<>();
		try {
			MeetingMapper mapper = session.getMapper(MeetingMapper.class);
			meetingList = mapper.retrieveMeetingsByHost(hostId);
		
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			session.close();
		}

		return meetingList;
	}

	@Override
	public Meeting retrieveMeetingByMeetingId(int meetingId) {

		SqlSession session = factory.openSession();
		Meeting meeting = new Meeting();
		try {
			MeetingMapper mapper = session.getMapper(MeetingMapper.class);
			meeting = mapper.retrieveMeetingByMeetingId(meetingId);
		
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			session.close();
		}

		return meeting;
	}

	@Override
	public List<String> retrieveJoinListByMeetingId(int meetingId) {

		SqlSession session = factory.openSession();
		List<String> joinList = new ArrayList<>();
		try {
			MeetingMapper mapper = session.getMapper(MeetingMapper.class);
			joinList = mapper.retrieveJoinListByMeetingId(meetingId);
		
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			session.close();
		}

		return joinList;
	}

	@Override
	public List<String> retrieveImageListByMeetingId(int meetingId) {

		SqlSession session = factory.openSession();
		List<String> imageList = new ArrayList<>();
		try {
			MeetingMapper mapper = session.getMapper(MeetingMapper.class);
			imageList = mapper.retrieveImageListByMeetingId(meetingId);
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			session.close();
		}

		return imageList;
	}

	@Override
	public boolean joinMeeting(int meetingId, String guestId) {

		SqlSession session = factory.openSession();
		Map<String, Object> map = new HashMap<>();
		boolean result = false;
		
		try {
			MeetingMapper mapper = session.getMapper(MeetingMapper.class);
			
			map.put("meetingId", meetingId);
			map.put("guestId", guestId);
			
			result = mapper.joinMeeting(map);
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			session.close();
		}

		return result;
	}

	@Override
	public boolean cancelMeeting(int meetingId, String guestId) {

		SqlSession session = factory.openSession();
		boolean result = false;
		Map<String, Object> map = new HashMap<>();
		
		try {
			MeetingMapper mapper = session.getMapper(MeetingMapper.class);
			map.put("meetingId", meetingId);
			map.put("guestId", guestId);
			
			result = mapper.cancelMeeting(map);
			
			if(result) {
				session.commit();
			}else {
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
	public boolean cancelAllJoinList(int meetingId) {

		SqlSession session = factory.openSession();
		
		boolean result = false;

		try {
			MeetingMapper mapper = session.getMapper(MeetingMapper.class);
		
			result = mapper.cancelAllJoinList(meetingId);
		
			if(result) {
				session.commit();
			}else {
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
	public boolean updateMeeting(Meeting meeting) {

		SqlSession session = factory.openSession();
		boolean result = false;
		try {
			MeetingMapper mapper = session.getMapper(MeetingMapper.class);
			result = mapper.updateMeeting(meeting);
			
			if(result) {
				session.commit();
			}else{
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
	public boolean deleteMeeting(int meetingId) {

		SqlSession session = factory.openSession();

		boolean result = false;
		try {
			MeetingMapper mapper = session.getMapper(MeetingMapper.class);
	
			result = mapper.deleteMeeting(meetingId);
		
			if(result) {
				session.commit();
			}else {
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
