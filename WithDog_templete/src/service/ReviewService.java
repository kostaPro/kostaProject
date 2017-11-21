package service;

import java.util.List;

import domain.Review;

public interface ReviewService {
	
	boolean registReview(Review review);
	Review findReviewByReviewId(int reviewId);
	List<String> findReviewsByWriterId(String writerId);
	boolean modifyReview(Review review);
	boolean removeReview(int reviewId);

}
