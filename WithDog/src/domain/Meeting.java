package domain;

import java.sql.Date;
import java.util.List;

public class Meeting {
	
	private int meetingId;
	private Date meetingDate;
	private int meetingTime;
	private String meetingSpot;
	private int minPerson;
	private String meetingPurpose;
	private List<String> meetingImageList;
	private String hostId;
	private List<User> meetingJoinList;
	private List<Comment> commentList;
	
	public int getMeetingId() {
		return meetingId;
	}
	public void setMeetingId(int meetingId) {
		this.meetingId = meetingId;
	}
	public Date getMeetingDate() {
		return meetingDate;
	}
	public void setMeetingDate(Date meetingDate) {
		this.meetingDate = meetingDate;
	}
	public int getMeetingTime() {
		return meetingTime;
	}
	public void setMeetingTime(int meetingTime) {
		this.meetingTime = meetingTime;
	}
	public String getMeetingSpot() {
		return meetingSpot;
	}
	public void setMeetingSpot(String meetingSpot) {
		this.meetingSpot = meetingSpot;
	}
	public int getMinPerson() {
		return minPerson;
	}
	public void setMinPerson(int minPerson) {
		this.minPerson = minPerson;
	}
	public String getMeetingPurpose() {
		return meetingPurpose;
	}
	public void setMeetingPurpose(String meetingPurpose) {
		this.meetingPurpose = meetingPurpose;
	}
	public List<String> getMeetingImageList() {
		return meetingImageList;
	}
	public void setMeetingImageList(List<String> meetingImageList) {
		this.meetingImageList = meetingImageList;
	}
	public String getHostId() {
		return hostId;
	}
	public void setHostId(String hostId) {
		this.hostId = hostId;
	}
	public List<User> getMeetingJoinList() {
		return meetingJoinList;
	}
	public void setMeetingJoinList(List<User> meetingJoinList) {
		this.meetingJoinList = meetingJoinList;
	}
	public List<Comment> getCommentList() {
		return commentList;
	}
	public void setCommentList(List<Comment> commentList) {
		this.commentList = commentList;
	}

}
