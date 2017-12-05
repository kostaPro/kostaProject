package store;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import domain.User;
import service.logic.EventServiceLogic;
import store.logic.EventStoreLogic;
import store.logic.UserStoreLogic;

public class UserStoreLogicTest {
	UserStore store;
	EventStore eventStore;

	@Before
	public void setUp() {
		store = new UserStoreLogic();
		eventStore = new EventStoreLogic();
	}

//	@Test
//	public void testCreateUser() {
//		User user = new User();
//		
//		user.setUserId("Hoon");
//		user.setPassword("1234");
//		user.setFavoriteLocation("gimje");
//		user.setContact("01029182135");
//		user.setPetInfo("dragon");
//		user.setPetImage("pet1.jpg");
//		
//		store.createUser(user);
//	}

	
	
//	@Test
//	public void testUpdateUser() {
//		
//		User user = store.retrieveUserByUserId("uraid");
//	
//		user.setPassword("1234");
//		user.setFavoriteLocation("seoul");
//		user.setContact("01029182135");
//		user.setPetInfo("Yorkshire Terrier");
//		user.setPetImage("pet.jpg");
//		
//		store.updateUser(user);
//		
//	}

//	@Test
//	public void testDeleteUser() {
//		
//		store.deleteUser("uraid");
//	
//	}

//	@Test
//	public void testRetrieveUserByUserId() {
//	
//		User user = store.retrieveUserByUserId("uraid");
//		assertEquals("01022229999", user.getContact());
//		
//				
//	}

	@Test
	public void testRetrieveUserList() {
		
		Date eventDate = null;
		try {
			eventDate = new SimpleDateFormat("yyyy-MM-dd").parse("2017-12-06");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<String> ids = eventStore.retrieveJoinListByEventDate(2, eventDate);
		System.out.println(ids);
		
		List<User> list = store.retrieveUserList(ids);
		assertEquals(3, list.size());
		assertEquals("인천", list.get(0).getFavoriteLocation());
		
		System.out.println(list);
	}

}
