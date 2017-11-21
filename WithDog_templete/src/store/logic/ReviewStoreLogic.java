package store.logic;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import domain.Review;
import store.ReviewStore;
import store.factory.SqlSessionFactoryProvider;

@Repository
public class ReviewStoreLogic implements ReviewStore {

	private SqlSessionFactory factory;

	public ReviewStoreLogic() {
		factory = SqlSessionFactoryProvider.getSqlSessionFactory();
	}

	@Override
	public boolean createReview(Review review) {

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
	public List<Review> retrieveReviewsBySpotId(int spotId) {

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
	public Review retrieveReviewByReviewId(int reviewId) {

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
	public List<String> retrieveReviewsByWriterId(String writerId) {

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
	public List<String> retrieveImageListByReviewId(int reviewId) {

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
	public boolean updateReview(Review review) {

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
	public boolean deleteReview(int reviewId) {

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
