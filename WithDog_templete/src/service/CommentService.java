package service;

import domain.Comment;

public interface CommentService {
	
	boolean registEventComment(Comment comment);
	boolean registMeetingComment(Comment comment);
	boolean registReviewComment(Comment comment);
	Comment findCommentByCommentId(int commentId);
	boolean modifyEventComment(Comment comment);
	boolean modifyMeetingComment(Comment comment);
	boolean modifyReviewComment(Comment comment);
	boolean removeEventComment(int commentId);
	boolean removeAllEventComment(int eventId);
	boolean removeMeetingComment(int commentId);
	boolean removeAllMeetingComment(int meetingId);
	boolean removeReviewComment(int commentId);
	boolean removeAllReviewComment(int reviewId);

}
