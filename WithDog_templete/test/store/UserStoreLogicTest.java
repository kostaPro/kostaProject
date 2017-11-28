package store;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import domain.User;
import store.logic.UserStoreLogic;

public class UserStoreLogicTest {
	UserStore store;

	@Before
	public void setUp() {
		store = new UserStoreLogic();
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

	@Test
	public void testRetrieveUserByUserId() {
	
		User user = store.retrieveUserByUserId("uraid");
		assertEquals("01022229999", user.getContact());
		
				
	}

	@Test
	public void testRetrieveUserList() {
		List<String> ids = new ArrayList<>();
		ids.add("uraid");
		ids.add("Hoon");
		
		List<User> list = store.retrieveUserList(ids);
		assertEquals(2, list.size());
	}

}
