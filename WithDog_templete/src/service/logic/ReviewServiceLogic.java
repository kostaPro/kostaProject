package service.logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import domain.Comment;
import domain.Review;
import service.ReviewService;
import store.CommentStore;
import store.ReviewStore;

@Service
public class ReviewServiceLogic implements ReviewService{
	
	@Autowired
	private ReviewStore reviewStore;
	@Autowired
	private CommentStore commentStore;

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
		
		List<Comment> list = commentStore.retrieveCommentsByReviewId(reviewId);
		for (int i = 0; i < list.size(); i++) {
			int comment = list.get(i).getCommentId();
			result = commentStore.deleteEventComment(comment);
		}
		return result;
	}
}
