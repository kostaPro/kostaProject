package store.logic;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import domain.Review;
import store.ReviewStore;
import store.factory.SqlSessionFactoryProvider;
import store.mapper.ReviewMapper;

@Repository
public class ReviewStoreLogic implements ReviewStore {

	private SqlSessionFactory factory;

	public ReviewStoreLogic() {
		factory = SqlSessionFactoryProvider.getSqlSessionFactory();
	}

	@Override
	public boolean createReview(Review review) {

		SqlSession session = factory.openSession();
		
		boolean result = false;

		try {
			ReviewMapper mapper = session.getMapper(ReviewMapper.class);
			result = mapper.createReview(review);
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
	public List<Review> retrieveReviewsBySpotId(int spotId) {

		SqlSession session = factory.openSession();
		List<Review> list = null;

		try {
			ReviewMapper mapper = session.getMapper(ReviewMapper.class);
			list = mapper.retrieveReviewsBySpotId(spotId);
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			session.close();
		}

		return list;
	}

	@Override
	public Review retrieveReviewByReviewId(int reviewId) {

		SqlSession session = factory.openSession();
		Review review = null;

		try {
			ReviewMapper mapper = session.getMapper(ReviewMapper.class);
			review = mapper.retrieveReviewByReviewId(reviewId);
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			session.close();
		}

		return review;
	}

	@Override
	public List<String> retrieveReviewsByWriterId(String writerId) {

		SqlSession session = factory.openSession();
		List<String> list = null;

		try {
			ReviewMapper mapper = session.getMapper(ReviewMapper.class);
			list = mapper.retrieveReviewsByWriterId(writerId);
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			session.close();
		}

		return list;
	}

	@Override
	public List<String> retrieveImageListByReviewId(int reviewId) {

		SqlSession session = factory.openSession();
		List<String> list = null;

		try {
			ReviewMapper mapper = session.getMapper(ReviewMapper.class);
			list = mapper.retrieveImageListByReviewId(reviewId);
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			session.close();
		}

		return list;
	}

	@Override
	public boolean updateReview(Review review) {

		SqlSession session = factory.openSession();
		boolean result = false;

		try {
			ReviewMapper mapper = session.getMapper(ReviewMapper.class);
			result = mapper.updateReview(review);
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
	public boolean deleteReview(int reviewId) {

		SqlSession session = factory.openSession();
		boolean result = false;

		try {
			ReviewMapper mapper = session.getMapper(ReviewMapper.class);
			result = mapper.deleteReview(reviewId);
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
