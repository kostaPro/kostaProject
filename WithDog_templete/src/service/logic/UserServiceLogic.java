package service.logic;

import java.util.List;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import domain.User;
import service.UserService;
import store.UserStore;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"file:WebContent/WEB-INF/dispatcher-servlet.xml"})
@Service
public class UserServiceLogic implements UserService{
	
	@Autowired
	private UserStore userStore;

	
	@Override
	public boolean registUser(User user) {
		
		return userStore.createUser(user);
	} 

	@Override
	public boolean modifyUser(User user) {
		
		return userStore.updateUser(user);
	}

	@Override
	public boolean removeUser(String userId) {
		
		return userStore.deleteUser(userId);
	}

	@Override
	public User findUserByUserId(String userId) {
		
		return userStore.retrieveUserByUserId(userId);
	}

	@Override
	public List<User> findUserList(List<String> userIdList) {
		
		return userStore.retrieveUserList(userIdList);
	}

}
