package service;

import java.util.List;

import domain.Comment;
import domain.Review;

public interface ReviewService {
	
	boolean registReview(Review review);
	boolean registReviewImage(String imageUrl, int reviewId);
	Review findReviewByReviewId(int reviewId);
	List<Comment> findCommentByReviewId(int reviewId);
	List<Review> findReviewsByWriterId(String writerId);
	boolean modifyReview(Review review);
	boolean removeReview(int reviewId);

}
