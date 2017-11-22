package store;

import static org.junit.Assert.*;

import java.sql.Date;
import java.util.List;

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

//	@Test
//	public void testCreateReview() {	
//		
//		Date date = new Date(2017/11/11);
//		
//		Review review = new Review();
//		review.setTitle("test");
//		review.setContent("하이욤");
//		review.setRegistDate(date);
//		review.setWriterId("jakook");
//		review.setSpotId(1);
//		
//		store.createReview(review);
//	}
//
//	@Test
//	public void testRetrieveReviewsBySpotId() {
//		List<Review> list = store.retrieveReviewsBySpotId(1);
//		assertEquals(1, list.get(1).getSpotId());
//	}
//
	@Test
	public void testRetrieveReviewByReviewId() {
		Review review = store.retrieveReviewByReviewId(3);
		assertEquals(3, review.getReviewId());
//		assertEquals(1, review.getReviewImageList().size());
//		assertEquals(1, review.getCommentList().size());
	}
//
//	@Test
//	public void testRetrieveReviewsByWriterId() {
//		List<Review> list = store.retrieveReviewsByWriterId("jakook");
//		assertEquals("jakook", list.get(0).getWriterId());
//	}
//
//	@Test
//	public void testRetrieveImageListByReviewId() {
//		List<String> list = store.retrieveImageListByReviewId(3);
//		assertEquals("c//withdog", list.get(0));
//	}

//	@Test
//	public void testUpdateReview() {
//	Review rev = store.retrieveReviewByReviewId(2);
//	rev.setContent("호호호");
//	store.updateReview(rev);
//	}
//
//	@Test
//	public void testDeleteReview() {
//		store.deleteReview(2);
//	}
//	
//	@Test
//	public void testCreateReviewImage() {
//		store.createReviewImage("string", 4);
//	}

}
