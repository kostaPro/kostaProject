package service.logic;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import domain.Comment;
import domain.Meeting;
import service.MeetingService;
import store.CommentStore;
import store.MeetingStore;
import store.UserStore;

@Service
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"file:WebContent/WEB-INF/dispatcher-servlet.xml"})
public class MeetingServiceLogic implements MeetingService{
	
	@Autowired
	private MeetingStore meetingStore;
	@Autowired
	private CommentStore commentStore;
	

//	@Test
//	public void testRegistReview() {
//		removeMeeting(12);
//	}
	
	
	@Override
	public boolean registMeeting(Meeting meeting) {
		
		return meetingStore.createMeeting(meeting);
	}

	@Override
	public List<Meeting> findAllMeetings() {
	
		return meetingStore.retrieveAllMeetings();
	}

	@Override
	public List<Meeting> findMeetingsByLocation(String loaction) {
		
		return meetingStore.retrieveMeetingsByLocation(loaction);
	}

	@Override
	public List<Meeting> findMeetingsByDate(Date date) {
		
		return meetingStore.retrieveMeetingsByDate(date);
	}

	@Override
	public List<Meeting> findMeetingsByLocationDate(String location, Date date) {
		
		return meetingStore.retrieveMeetingsByLocationDate(location, date);
	}

	@Override
	public List<Meeting> findMeetingsByGuest(String guestId) {
	
		return meetingStore.retrieveMeetingsByGuest(guestId);
	}

	@Override
	public List<Meeting> findMeetingsByHost(String hostId) {
		
		return meetingStore.retrieveMeetingsByHost(hostId);
	}

	@Override
	public Meeting findMeetingByMeetingId(int meetingId) {
		Meeting meeting = meetingStore.retrieveMeetingByMeetingId(meetingId);
		meeting.setCommentList(findCommentByMeetingId(meetingId));
		meeting.setMeetingImageList(meetingStore.retrieveImageListByMeetingId(meetingId));
		meeting.setMeetingJoinList(meetingStore.retrieveJoinListByMeetingId(meetingId));
		
		return meeting;
	}

	@Override
	public boolean joinMeeting(int meetingId, String guestId) {
	
		return meetingStore.joinMeeting(meetingId, guestId);
	}

	@Override
	public boolean cancelMeeting(int meetingId, String guestId) {
		
		return meetingStore.cancelMeeting(meetingId, guestId);
	}

	@Override
	public boolean modifyMeeting(Meeting meeting) {
		
		return meetingStore.updateMeeting(meeting);
	}

	@Override
	public boolean removeMeeting(int meetingId) {
		boolean result = false;

		result = meetingStore.deleteMeeting(meetingId);
		if(result) {
			commentStore.deleteMeetingCommentList(meetingId);
			meetingStore.cancelAllJoinList(meetingId);
		}
		
		return result;
	}


	@Override
	public boolean registMeetingImage(String imageUrl, int meetingId) {
		return meetingStore.createMeetingImage(imageUrl, meetingId);
	}
	
	@Override
	public List<Comment> findCommentByMeetingId(int meetingId) {
		List<Comment> meetingCommentList = commentStore.retrieveCommentsByMeetingId(meetingId);
		
		//부모
		List<Comment> meetingCommentListParent = new ArrayList<Comment>();
		//자식
		List<Comment> meetingCommentListChild = new ArrayList<Comment>();
		//통합
		List<Comment> newMeetingCommentList = new ArrayList<Comment>();
		
		//부모 자식 분리
		for(Comment comment : meetingCommentList) {
			if(comment.getDepth().equals("0")) {
				meetingCommentListParent.add(comment);
			}else {
				meetingCommentListChild.add(comment);
			}
		}
		//로직
		for(Comment meetingCommentParent : meetingCommentListParent) {
			newMeetingCommentList.add(meetingCommentParent);
			for(Comment meetingCommentChild : meetingCommentListChild) {
				String commentId = String.valueOf(meetingCommentParent.getCommentId());
				if(commentId.equals(meetingCommentChild.getParentId())) {
					newMeetingCommentList.add(meetingCommentChild);
				}
			}
		}
		return newMeetingCommentList;
	}
	
}
