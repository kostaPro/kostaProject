package store;

import static org.junit.Assert.*;

import java.sql.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import domain.Comment;
import store.logic.CommentStoreLogic;

public class CommentStoreLogicTest {
	private CommentStore store;

	@Before
	public void setUp() {
		store = new CommentStoreLogic();
	}

//	@Test
//	public void testCreateEventComment() {
//		Date date = new Date(2017/11/11);
//		
//		Comment com = new Comment();
//		com.setContent("하요");
//		com.setRegistDate(date);
//		com.setWriterId("jakook");
//		com.setTargetId(1);
//		
//		store.createEventComment(com);
//	}
//
//	@Test
//	public void testCreateReviewComment() {
//		Comment com = new Comment();
//		com.setContent("하요");
//		com.setWriterId("jakook");
//		com.setTargetId(1);
//		
//		store.createReviewComment(com);
//	}
//
//	@Test
//	public void testCreateMeetingComment() {
//		Comment com = new Comment();
//		com.setContent("하요");
//		com.setWriterId("jakook");
//		com.setTargetId(1);
//		
//		store.createMeetingComment(com);
//	}

	@Test
	public void testRetrieveCommentsByReviewId() {
		List<Comment> list = store.retrieveCommentsByReviewId(1);

	}

	@Test
	public void testRetrieveCommentsByMeetingId() {
	
	}

	@Test
	public void testRetrieveCommentsByEventId() {
		
	}

	@Test
	public void testRetrieveCommentByCommentId() {
	
	}

	@Test
	public void testRetrieveReplyListByParentCommentId() {
	
	}

	@Test
	public void testUpdateEventComment() {
		
	}

	@Test
	public void testUpdateReviewComment() {
		
	}

	@Test
	public void testUpdateMeetingComment() {
		
	}

	@Test
	public void testDeleteEventComment() {
	
	}

	@Test
	public void testDeleteReviewComment() {
		
	}

	@Test
	public void testDeleteMeetingComment() {
		
	}

	@Test
	public void testDeleteEventCommentList() {
		
	}

	@Test
	public void testDeleteReviewCommentList() {
		
	}

	@Test
	public void testDeleteMeetingCommentList() {
		
	}

}
