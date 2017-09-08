package board.web.servlet.store;

import java.util.List;

import board.web.servlet.domain.Comment;

public interface CommentStore {

	String create(Comment comment);
	List<Comment> retrieveAll(String articleId);
	void delete(String commentId);
}
