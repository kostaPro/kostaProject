package board.web.servlet.store.mapper;

import java.util.List;

import board.web.servlet.domain.Comment;

public interface CommentMapper {

	void insert(Comment comment);

	List<Comment> selectAll(String articleId);

	void delete(String commentId);

}
