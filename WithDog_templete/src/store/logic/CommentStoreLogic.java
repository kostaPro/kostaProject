package store.logic;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import domain.Comment;
import store.CommentStore;
import store.factory.SqlSessionFactoryProvider;
import store.mapper.CommentMapper;

@Repository
public class CommentStoreLogic implements CommentStore{
	
	private SqlSessionFactory factory;

	public CommentStoreLogic() {
		factory = SqlSessionFactoryProvider.getSqlSessionFactory();
	}

	@Override
	public boolean createEventComment(Comment comment) {

		SqlSession session = factory.openSession();
		boolean result = false;

		try {
			CommentMapper mapper = session.getMapper(CommentMapper.class);
			result = mapper.createEventComment(comment);
			if (result) {
				session.commit();
			} else {
				session.rollback();
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			session.close();
		}

		return result;
	}

	@Override
	public boolean createReviewComment(Comment comment) {

		SqlSession session = factory.openSession();
		boolean result = false;

		try {
			CommentMapper mapper = session.getMapper(CommentMapper.class);
			result = mapper.createReviewComment(comment);
			if (result) {
				session.commit();
			} else {
				session.rollback();
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			session.close();
		}

		return result;
	}

	@Override
	public boolean createMeetingComment(Comment comment) {

		SqlSession session = factory.openSession();
		boolean result = false;

		try {
			CommentMapper mapper = session.getMapper(CommentMapper.class);
			result = mapper.createMeetingComment(comment);
			if (result) {
				session.commit();
			} else {
				session.rollback();
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			session.close();
		}

		return result;
	}

	@Override
	public List<Comment> retrieveCommentsByReviewId(int reviewId) {

		SqlSession session = factory.openSession();
		List<Comment> list = null;

		try {
			CommentMapper mapper = session.getMapper(CommentMapper.class);
			list = mapper.retrieveCommentsByReviewId(reviewId);
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			session.close();
		}

		return list;
	}

	@Override
	public List<Comment> retrieveCommentsByMeetingId(int meetingId) {

		SqlSession session = factory.openSession();
		List<Comment> list = null;

		try {
			CommentMapper mapper = session.getMapper(CommentMapper.class);
			list = mapper.retrieveCommentsByMeetingId(meetingId);
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			session.close();
		}

		return list;
	}

	@Override
	public List<Comment> retrieveCommentsByEventId(int eventId) {

		SqlSession session = factory.openSession();
		List<Comment> list = null;

		try {
			CommentMapper mapper = session.getMapper(CommentMapper.class);
			list = mapper.retrieveCommentsByEventId(eventId);
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			session.close();
		}

		return list;
	}

	@Override
	public Comment retrieveCommentByCommentId(int commentId) {

		SqlSession session = factory.openSession();
		Comment comment = null;

		try {
			CommentMapper mapper = session.getMapper(CommentMapper.class);
			comment = mapper.retrieveCommentByCommentId(commentId);
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			session.close();
		}

		return comment;
	}

	@Override
	public List<Comment> retrieveReplyListByParentCommentId(int parentCommentId) {

		SqlSession session = factory.openSession();
		List<Comment> list = null;

		try {
			CommentMapper mapper = session.getMapper(CommentMapper.class);
			list = mapper.retrieveReplyListByParentCommentId(parentCommentId);
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			session.close();
		}

		return list;
	}

	@Override
	public boolean updateEventComment(Comment comment) {

		SqlSession session = factory.openSession();
		boolean result = false;

		try {
			CommentMapper mapper = session.getMapper(CommentMapper.class);
			result = mapper.updateEventComment(comment);
			if (result) {
				session.commit();
			} else {
				session.rollback();
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			session.close();
		}

		return result;
	}

	@Override
	public boolean updateReviewComment(Comment comment) {

		SqlSession session = factory.openSession();
		boolean result = false;

		try {
			CommentMapper mapper = session.getMapper(CommentMapper.class);
			result = mapper.updateReviewComment(comment);
			if (result) {
				session.commit();
			} else {
				session.rollback();
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			session.close();
		}

		return result;
	}

	@Override
	public boolean updateMeetingComment(Comment comment) {

		SqlSession session = factory.openSession();
		boolean result = false;

		try {
			CommentMapper mapper = session.getMapper(CommentMapper.class);
			result = mapper.updateMeetingComment(comment);
			if (result) {
				session.commit();
			} else {
				session.rollback();
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			session.close();
		}

		return result;
	}

	@Override
	public boolean deleteEventComment(int commentId) {

		SqlSession session = factory.openSession();
		boolean result = false;

		try {
			CommentMapper mapper = session.getMapper(CommentMapper.class);
			result = mapper.deleteEventComment(commentId);
			if (result) {
				session.commit();
			} else {
				session.rollback();
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			session.close();
		}

		return result;
	}

	@Override
	public boolean deleteReviewComment(int commentId) {

		SqlSession session = factory.openSession();
		boolean result = false;

		try {
			CommentMapper mapper = session.getMapper(CommentMapper.class);
			result = mapper.deleteReviewComment(commentId);
			if (result) {
				session.commit();
			} else {
				session.rollback();
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			session.close();
		}

		return result;
	}

	@Override
	public boolean deleteMeetingComment(int commentId) {

		SqlSession session = factory.openSession();
		boolean result = false;

		try {
			CommentMapper mapper = session.getMapper(CommentMapper.class);
			result = mapper.deleteMeetingComment(commentId);
			if (result) {
				session.commit();
			} else {
				session.rollback();
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			session.close();
		}

		return result;
	}

	@Override
	public boolean deleteEventCommentList(int eventId) {

		SqlSession session = factory.openSession();
		boolean result = false;

		try {
			CommentMapper mapper = session.getMapper(CommentMapper.class);
			result = mapper.deleteEventCommentList(eventId);
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			session.close();
		}

		return result;
	}

	@Override
	public boolean deleteReviewCommentList(int reviewId) {

		SqlSession session = factory.openSession();
		boolean result = false;

		try {
			CommentMapper mapper = session.getMapper(CommentMapper.class);
			result = mapper.deleteReviewCommentList(reviewId);
			if (result) {
				session.commit();
			} else {
				session.rollback();
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			session.close();
		}

		return result;
	}

	@Override
	public boolean deleteMeetingCommentList(int meetingId) {

		SqlSession session = factory.openSession();
		boolean result = false;

		try {
			CommentMapper mapper = session.getMapper(CommentMapper.class);
			result = mapper.deleteMeetingCommentList(meetingId);
			if (result) {
				session.commit();
			} else {
				session.rollback();
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			session.close();
		}

		return result;
	}

}
