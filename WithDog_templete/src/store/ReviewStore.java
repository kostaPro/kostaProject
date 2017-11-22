package store;

import java.util.List;

import domain.Review;

public interface ReviewStore {
	
	boolean createReview(Review review);
	boolean createReviewImage(String imageUrl, int reviewId);
	List<Review> retrieveReviewsBySpotId(int spotId);
	Review retrieveReviewByReviewId(int reviewId);
	List<Review> retrieveReviewsByWriterId(String writerId);
	List<String> retrieveImageListByReviewId(int reviewId);
	boolean updateReview(Review review);
	boolean deleteReview(int reviewId);

}
