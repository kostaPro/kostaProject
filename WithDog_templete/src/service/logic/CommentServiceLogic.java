package service.logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import domain.Comment;
import service.CommentService;
import store.CommentStore;

@Service
public class CommentServiceLogic implements CommentService{
	
	@Autowired
	private CommentStore commentStore;

	@Override
	public boolean registEventComment(Comment comment, int eventId, int parentReplyId) {
		
		return false;
	}

	@Override
	public boolean registMeetingComment(Comment comment, int meetingId) {
	
		return false;
	}

	@Override
	public boolean registReviewComment(Comment comment, int reviewId) {
	
		return false;
	}

	@Override
	public List<Comment> findCommentsByWriterId(String writerId) {
		
		return null;
	}

	@Override
	public Comment findCommentByCommentId(int commentId) {
	
		return null;
	}

	@Override
	public boolean modifyEventComment(Comment comment) {
		
		return false;
	}

	@Override
	public boolean modifyMeetingComment(Comment comment) {
		
		return false;
	}

	@Override
	public boolean modifyReviewComment(Comment comment) {
		
		return false;
	}

	@Override
	public boolean removeEventComment(int commentId) {
		
		return false;
	}

	@Override
	public boolean removeAllEventComment(int eventId) {
		
		return false;
	}

	@Override
	public boolean removeMeetingComment(int commentId) {
		
		return false;
	}

	@Override
	public boolean removeAllMeetingComment(int meetingId) {
		
		return false;
	}

	@Override
	public boolean removeReviewComment(int commentId) {
		
		return false;
	}

	@Override
	public boolean removeAllReviewComment(int reviewId) {
		
		return false;
	}

}
