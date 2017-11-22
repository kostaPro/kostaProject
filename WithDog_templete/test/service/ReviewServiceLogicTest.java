package service;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import domain.Review;
import service.logic.ReviewServiceLogic;

public class ReviewServiceLogicTest {
	private ReviewService service;

	@Before
	public void setUp(){
		service = new ReviewServiceLogic();
	}

	@Test
	public void testRegistReview() {
		Review r = new Review();
		r.setTitle("test");
		r.setContent("하이");
		r.setWriterId("j");
		r.setSpotId(3);
		
		service.registReview(r);
	}

	@Test
	public void testRegistReviewImage() {
		
	}

	@Test
	public void testFindReviewByReviewId() {
	
	}

	@Test
	public void testFindReviewsByWriterId() {
		
	}

	@Test
	public void testModifyReview() {
	
	}

	@Test
	public void testRemoveReview() {
//		service.removeReview(1);
	}

}
