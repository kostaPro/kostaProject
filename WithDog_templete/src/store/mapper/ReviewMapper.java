package store.mapper;

import java.util.List;
import java.util.Map;

import domain.Review;

public interface ReviewMapper {
	
	boolean createReview(Review review);
	boolean createReviewImage(Map<String, Object> map);
	
	List<Review> retrieveReviewsBySpotId(int spotId);
	
	Review retrieveReviewByReviewId(int reviewId);
	
	List<Review> retrieveReviewsByWriterId(String writerId);
	List<String> retrieveImageListByReviewId(int reviewId);
	
	boolean updateReview(Review review);
	
	boolean deleteReview(int reviewId);
	
	boolean deleteReviewImage(int reviewId);
}
