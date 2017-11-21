package service.logic;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import domain.Meeting;
import service.MeetingService;
import store.CommentStore;
import store.MeetingStore;
import store.UserStore;

@Service
public class MeetingServiceLogic implements MeetingService{
	
	@Autowired
	private MeetingStore meetingStore;
	@Autowired
	private CommentStore commentStore;
	@Autowired
	private UserStore userStore;

	@Override
	public boolean registMeeting(Meeting meeting) {
		
		return false;
	}

	@Override
	public boolean findAllMeetings() {
	
		return false;
	}

	@Override
	public List<Meeting> findMeetingsByLocation(String loaction) {
		
		return null;
	}

	@Override
	public List<Meeting> findMeetingsByDate(Date date) {
		
		return null;
	}

	@Override
	public List<Meeting> findMeetingsByLocationDate(String location, Date date) {
		
		return null;
	}

	@Override
	public List<Meeting> findMeetingsByGuest(String guestId) {
	
		return null;
	}

	@Override
	public List<Meeting> findMeetingsByHost(String hostId) {
		
		return null;
	}

	@Override
	public Meeting findMeetingByMeetingId(int meetingId) {
	
		return null;
	}

	@Override
	public boolean joinMeeting(int meetingId, String guestId) {
	
		return false;
	}

	@Override
	public boolean cancelMeeting(int meetingId, String guestId) {
		
		return false;
	}

	@Override
	public boolean modifyMeeting(Meeting meeting) {
		
		return false;
	}

	@Override
	public boolean removeMeeting(int meetingId) {
		
		return false;
	}

}
