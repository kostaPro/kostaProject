package service.logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
		
		return false;
	}

	@Override
	public Review findReviewByReviewId(int reviewId) {
		
		return null;
	}

	@Override
	public List<String> findReviewsByWriterId(String writerId) {
		
		return null;
	}

	@Override
	public boolean modifyReview(Review review) {
		
		return false;
	}

	@Override
	public boolean removeReview(int reviewId) {
		
		return false;
	}

}
