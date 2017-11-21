package store.logic;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import domain.Comment;
import store.CommentStore;
import store.factory.SqlSessionFactoryProvider;

@Repository
public class CommentStoreLogic implements CommentStore{
	
	private SqlSessionFactory factory;

	public CommentStoreLogic() {
		factory = SqlSessionFactoryProvider.getSqlSessionFactory();
	}

	@Override
	public boolean createEventComment(Comment comment) {

		SqlSession session = factory.openSession();

		try {

		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			session.close();
		}

		return false;
	}

	@Override
	public boolean createReviewComment(Comment comment) {

		SqlSession session = factory.openSession();

		try {

		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			session.close();
		}

		return false;
	}

	@Override
	public boolean createMeetingComment(Comment comment) {

		SqlSession session = factory.openSession();

		try {

		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			session.close();
		}

		return false;
	}

	@Override
	public List<Comment> retrieveCommentsByReviewId(int reviewId) {

		SqlSession session = factory.openSession();

		try {

		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			session.close();
		}

		return null;
	}

	@Override
	public List<Comment> retrieveCommentsByMeetingId(int meetingId) {

		SqlSession session = factory.openSession();

		try {

		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			session.close();
		}

		return null;
	}

	@Override
	public List<Comment> retrieveCommentsByEventId(int eventId) {

		SqlSession session = factory.openSession();

		try {

		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			session.close();
		}

		return null;
	}

	@Override
	public List<Comment> retrieveCommentsByWriterId(String writerId) {

		SqlSession session = factory.openSession();

		try {

		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			session.close();
		}

		return null;
	}

	@Override
	public Comment retrieveCommentByCommentId(int commentId) {

		SqlSession session = factory.openSession();

		try {

		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			session.close();
		}

		return null;
	}

	@Override
	public List<Comment> retrieveReplyListByParentCommentId(int parentCommentId) {

		SqlSession session = factory.openSession();

		try {

		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			session.close();
		}

		return null;
	}

	@Override
	public boolean updateEventComment(Comment comment) {

		SqlSession session = factory.openSession();

		try {

		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			session.close();
		}

		return false;
	}

	@Override
	public boolean updateReviewComment(Comment comment) {

		SqlSession session = factory.openSession();

		try {

		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			session.close();
		}

		return false;
	}

	@Override
	public boolean updateMeetingComment(Comment comment) {

		SqlSession session = factory.openSession();

		try {

		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			session.close();
		}

		return false;
	}

	@Override
	public boolean deleteEventComment(int commentId) {

		SqlSession session = factory.openSession();

		try {

		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			session.close();
		}

		return false;
	}

	@Override
	public boolean deleteReviewComment(int commentId) {

		SqlSession session = factory.openSession();

		try {

		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			session.close();
		}

		return false;
	}

	@Override
	public boolean deleteMeetingComment(int commentId) {

		SqlSession session = factory.openSession();

		try {

		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			session.close();
		}

		return false;
	}

	@Override
	public boolean deleteEventCommentList(int eventId) {

		SqlSession session = factory.openSession();

		try {

		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			session.close();
		}

		return false;
	}

	@Override
	public boolean deleteReviewCommentList(int reviewId) {

		SqlSession session = factory.openSession();

		try {

		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			session.close();
		}

		return false;
	}

	@Override
	public boolean deleteMeetingCommentList(int meetingId) {

		SqlSession session = factory.openSession();

		try {

		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			session.close();
		}

		return false;
	}

}
