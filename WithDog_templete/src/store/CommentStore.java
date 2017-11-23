package store;

import java.util.List;

import domain.Comment;

public interface CommentStore {
	
	boolean createEventComment(Comment comment);
	boolean createReviewComment(Comment comment);
	boolean createMeetingComment(Comment comment);
	List<Comment> retrieveCommentsByReviewId(int reviewId);
	List<Comment> retrieveCommentsByMeetingId(int meetingId);
	List<Comment> retrieveCommentsByEventId(int eventId);
	Comment retrieveCommentByCommentId(int commentId);
	List<Comment> retrieveReplyListByParentCommentId(int parentCommentId);
	boolean updateEventComment(Comment comment);
	boolean updateReviewComment(Comment comment);
	boolean updateMeetingComment(Comment comment);
	boolean deleteEventComment(int commentId);
	boolean deleteReviewComment(int commentId);
	boolean deleteMeetingComment(int commentId);
	boolean deleteEventCommentList(int eventId);
	boolean deleteReviewCommentList(int reviewId);
	boolean deleteMeetingCommentList(int meetingId);

}
