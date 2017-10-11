package board.web.servlet.store.logic;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import board.web.servlet.domain.Comment;
import board.web.servlet.store.CommentStore;
import board.web.servlet.store.mapper.CommentMapper;

public class CommentStoreLogic implements CommentStore {

	@Override
	public String create(Comment comment) {
		SqlSession session = BoardSessionFactory.getInstance().getSession();

		try {
			CommentMapper mapper = session.getMapper(CommentMapper.class);
			mapper.insert(comment);
			session.commit();
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			session.close();
		}
		return comment.getCommentId();
	}

	@Override
	public List<Comment> retrieveAll(String articleId) {
		SqlSession session = BoardSessionFactory.getInstance().getSession();
		List<Comment> list = null;

		try {
			CommentMapper mapper = session.getMapper(CommentMapper.class);
			list = mapper.selectAll(articleId);
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			session.close();
		}
		return list;
	}

	@Override
	public void delete(String commentId) {
		SqlSession session = BoardSessionFactory.getInstance().getSession();

		try {
			CommentMapper mapper = session.getMapper(CommentMapper.class);
			mapper.delete(commentId);
			session.commit();
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			session.close();
		}

	}

}
