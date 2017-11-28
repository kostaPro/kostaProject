package store.mapper;

import java.util.Date;
import java.util.List;
import java.util.Map;

import domain.Meeting;

public interface MeetingMapper {
	
	boolean createMeeting(Meeting meeting);
	
	List<Meeting> retrieveAllMeetings();
	
	List<Meeting> retrieveMeetingsByLocation(String loaction);
	List<Meeting> retrieveMeetingsByDate(Date date);
	List<Meeting> retrieveMeetingsByLocationDate(Map<String, Object> map);
	List<Meeting> retrieveMeetingsByGuest(String guestId);
	List<Meeting> retrieveMeetingsByHost(String hostId);
	
	Meeting retrieveMeetingByMeetingId(int meetingId);
	
	boolean createMeetingImage(Map<String, Object> map);
	
	List<String> retrieveJoinListByMeetingId(int meetingId);
	
	List<String> retrieveImageListByMeetingId(int meetingId);
	
	boolean joinMeeting(Map<String, Object> map);
	
	boolean cancelMeeting(Map<String, Object> map);
	boolean cancelAllJoinList(int meetingId);
	
	boolean updateMeeting(Meeting meeting);
	
	boolean deleteMeeting(int meetingId);
}
