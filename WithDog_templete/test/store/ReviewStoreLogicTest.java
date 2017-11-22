package store;

import static org.junit.Assert.*;

import java.sql.Date;

import org.junit.Before;
import org.junit.Test;

import domain.Review;
import store.logic.ReviewStoreLogic;

public class ReviewStoreLogicTest {
	private ReviewStore store;

	@Before
	public void setUp(){
		store = new ReviewStoreLogic();
	}

	@Test
	public void testCreateReview() {	
		
		Date date = new Date(2017/11/11);
		
		Review review = new Review();
		review.setTitle("안녕");
		review.setContent("하이욤");
		review.setRegistDate(date);
		review.setWriterId("jakook");
		review.setSpotId(1);
		
		store.createReview(review);
	}
//
//	@Test
//	public void testRetrieveReviewsBySpotId() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testRetrieveReviewByReviewId() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testRetrieveReviewsByWriterId() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testRetrieveImageListByReviewId() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testUpdateReview() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testDeleteReview() {
//		fail("Not yet implemented");
//	}

}
