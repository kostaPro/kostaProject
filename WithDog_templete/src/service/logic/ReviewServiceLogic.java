package service.logic;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import domain.Review;
import service.ReviewService;
import store.CommentStore;
import store.ReviewStore;

@Service
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"file:WebContent/WEB-INF/dispatcher-servlet.xml"})
public class ReviewServiceLogic implements ReviewService{
	
	@Autowired
	private ReviewStore reviewStore;
	@Autowired
	private CommentStore commentStore;
	
//	@Test
//	public void testRegistReview() {
//		removeReview(3);
//	}

	@Override
	public boolean registReview(Review review) {
		
		return reviewStore.createReview(review);
	}
	
	@Override
	public boolean registReviewImage(String imageUrl, int reviewId) {
	
		return reviewStore.createReviewImage(imageUrl, reviewId);
	}

	@Override
	public Review findReviewByReviewId(int reviewId) {
		
		return reviewStore.retrieveReviewByReviewId(reviewId);
	}

	@Override
	public List<Review> findReviewsByWriterId(String writerId) {
		
		return reviewStore.retrieveReviewsByWriterId(writerId);
	}

	@Override
	public boolean modifyReview(Review review) {
		
		return reviewStore.updateReview(review);
	}

	@Override
	public boolean removeReview(int reviewId) {
		boolean result = false;
		
		result = reviewStore.deleteReview(reviewId);
		
		if(result) {
		commentStore.deleteReviewCommentList(reviewId);
		}
		return result;
	}
}
