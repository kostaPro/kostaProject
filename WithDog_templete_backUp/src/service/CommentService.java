package service;

import java.util.List;

import domain.Comment;

public interface CommentService {
	
	boolean registEventComment(Comment comment, int parentReplyId);
	boolean registMeetingComment(Comment comment);
	boolean registReviewComment(Comment comment);
	List<Comment> findCommentsByWriterId(String writerId);
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
