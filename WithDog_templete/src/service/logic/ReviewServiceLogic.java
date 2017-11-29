package service.logic;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import domain.Comment;
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
		Review review = reviewStore.retrieveReviewByReviewId(reviewId);
		review.setCommentList(findCommentByReviewId(reviewId));
		review.setReviewImageList(reviewStore.retrieveImageListByReviewId(reviewId));
		
		return review;
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
		reviewStore.deleteReviewImage(reviewId);
		}
		return result;
	}

	@Override
	public List<Comment> findCommentByReviewId(int reviewId) {
		List<Comment> reviewCommentList = commentStore.retrieveCommentsByReviewId(reviewId);
		
		//부모
		List<Comment> reviewCommentListParent = new ArrayList<Comment>();
		//자식
		List<Comment> reviewCommentListChild = new ArrayList<Comment>();
		//통합
		List<Comment> newReviewCommentList = new ArrayList<Comment>();
		
		//부모 자식 분리
		for(Comment comment : reviewCommentList) {
			if(comment.getDepth().equals("0")) {
				reviewCommentListParent.add(comment);
			}else {
				reviewCommentListChild.add(comment);
			}
		}
		//로직
		for(Comment reviewCommentParent : reviewCommentListParent) {
			newReviewCommentList.add(reviewCommentParent);
			for(Comment reviewCommentChild : reviewCommentListChild) {
				String commentId = String.valueOf(reviewCommentParent.getCommentId());
				if(commentId.equals(reviewCommentChild.getParentId())) {
					newReviewCommentList.add(reviewCommentChild);
				}
			}
		}
		return newReviewCommentList;
	}
}
