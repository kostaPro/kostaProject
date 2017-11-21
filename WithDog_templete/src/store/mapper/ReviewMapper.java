package store.mapper;

import java.util.List;

import domain.Review;

public interface ReviewMapper {
	
	boolean createReview(Review review);
	
	List<Review> retrieveReviewsBySpotId(int spotId);
	
	Review retrieveReviewByReviewId(int reviewId);
	
	List<String> retrieveReviewsByWriterId(String writerId);
	List<String> retrieveImageListByReviewId(int reviewId);
	
	boolean updateReview(Review review);
	
	boolean deleteReview(int reviewId);
}
