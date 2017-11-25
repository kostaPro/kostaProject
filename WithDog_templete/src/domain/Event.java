package domain;


import java.util.Date;
import java.util.List;
import java.util.Map;

public class Event {
	
	private int eventId;
	private String eventName;
	private Spot eventSpot;
	private String eventImage;
	private Date openDate;
	private Date closeDate;
	private String eventInfo;
	private Map<String, List<User>> eventJoinLists;
	private List<Comment> commentList;
	
	public int getEventId() {
		return eventId;
	}
	public void setEventId(int eventId) {
		this.eventId = eventId;
	}
	public String getEventName() {
		return eventName;
	}
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	public Spot getEventSpot() {
		return eventSpot;
	}
	public void setEventSpot(Spot eventSpot) {
		this.eventSpot = eventSpot;
	}
	public String getEventImage() {
		return eventImage;
	}
	public void setEventImage(String eventImage) {
		this.eventImage = eventImage;
	}
	public Date getOpenDate() {
		return openDate;
	}
	public void setOpenDate(Date openDate) {
		this.openDate = openDate;
	}
	public Date getCloseDate() {
		return closeDate;
	}
	public void setCloseDate(Date closeDate) {
		this.closeDate = closeDate;
	}
	public String getEventInfo() {
		return eventInfo;
	}
	public void setEventInfo(String eventInfo) {
		this.eventInfo = eventInfo;
	}
	public Map<String, List<User>> getEventJoinLists() {
		return eventJoinLists;
	}
	public void setEventJoinLists(Map<String, List<User>> eventJoinLists) {
		this.eventJoinLists = eventJoinLists;
	}
	public List<Comment> getCommentList() {
		return commentList;
	}
	public void setCommentList(List<Comment> commentList) {
		this.commentList = commentList;
	}

}
