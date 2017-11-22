package service.logic;

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
	public boolean registEventComment(Comment comment, int parentReplyId) {
		
		return commentStore.createEventComment(comment);
	}

	@Override
	public boolean registMeetingComment(Comment comment) {
	
		return commentStore.createMeetingComment(comment);
	}

	@Override
	public boolean registReviewComment(Comment comment) {
	
		return commentStore.createReviewComment(comment);
	}

	@Override
	public Comment findCommentByCommentId(int commentId) {
	
		return commentStore.retrieveCommentByCommentId(commentId);
	}

	@Override
	public boolean modifyEventComment(Comment comment) {
		
		return commentStore.updateEventComment(comment);
	}

	@Override
	public boolean modifyMeetingComment(Comment comment) {
		
		return commentStore.updateMeetingComment(comment);
	}

	@Override
	public boolean modifyReviewComment(Comment comment) {
		
		return commentStore.updateReviewComment(comment);
	}

	@Override
	public boolean removeEventComment(int commentId) {
		
		return commentStore.deleteEventComment(commentId);
	}

	@Override
	public boolean removeAllEventComment(int eventId) {
		
		return commentStore.deleteEventCommentList(eventId);
	}

	@Override
	public boolean removeMeetingComment(int commentId) {
		
		return commentStore.deleteMeetingComment(commentId);
	}

	@Override
	public boolean removeAllMeetingComment(int meetingId) {
		
		return commentStore.deleteMeetingCommentList(meetingId);
	}

	@Override
	public boolean removeReviewComment(int commentId) {
		
		return commentStore.deleteReviewComment(commentId);
	}

	@Override
	public boolean removeAllReviewComment(int reviewId) {
		
		return commentStore.deleteReviewCommentList(reviewId);
	}

}
