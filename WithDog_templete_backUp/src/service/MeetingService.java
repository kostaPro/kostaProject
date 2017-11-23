package service;

import java.sql.Date;
import java.util.List;

import domain.Meeting;

public interface MeetingService {
	
	boolean registMeeting(Meeting meeting);
	boolean findAllMeetings();
	List<Meeting> findMeetingsByLocation(String loaction);
	List<Meeting> findMeetingsByDate(Date date);
	List<Meeting> findMeetingsByLocationDate(String location, Date date);
	List<Meeting> findMeetingsByGuest(String guestId);
	List<Meeting> findMeetingsByHost(String hostId);
	Meeting findMeetingByMeetingId(int meetingId);
	boolean joinMeeting(int meetingId, String guestId);
	boolean cancelMeeting(int meetingId, String guestId);
	boolean modifyMeeting(Meeting meeting);
	boolean removeMeeting(int meetingId);

}
