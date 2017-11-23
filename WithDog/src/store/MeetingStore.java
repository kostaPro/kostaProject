package store;

import java.sql.Date;
import java.util.List;

import domain.Meeting;

public interface MeetingStore {
	
	boolean createMeeting(Meeting meeting);
	boolean retrieveAllMeetings();
	List<Meeting> retrieveMeetingsByLocation(String loaction);
	List<Meeting> retrieveMeetingsByDate(Date date);
	List<Meeting> retrieveMeetingsByLocationDate(String location, Date date);
	List<Meeting> retrieveMeetingsByGuest(String guestId);
	List<Meeting> retrieveMeetingsByHost(String hostId);
	Meeting retrieveMeetingByMeetingId(int meetingId);
	List<String> retrieveJoinListByMeetingId(int meetingId);
	List<String> retrieveImageListByMeetingId(int meetingId);
	boolean joinMeeting(int meetingId, String guestId);
	boolean cancelMeeting(int meetingId, String guestId);
	boolean cancelAllJoinList(int meetingId);
	boolean updateMeeting(Meeting meeting);
	boolean deleteMeeting(int meetingId);
}
