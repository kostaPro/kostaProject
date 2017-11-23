package service.logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import domain.User;
import service.UserService;
import store.UserStore;

@Service
public class UserServiceLogic implements UserService{
	
	@Autowired
	private UserStore userStore;

	@Override
	public boolean registUser(User user) {
		
		return false;
	}

	@Override
	public boolean modifyUser(User user) {
		
		return false;
	}

	@Override
	public boolean removeUser(String userId) {
		
		return false;
	}

	@Override
	public User findUserByUserId(String userId) {
		
		return null;
	}

	@Override
	public List<User> findUserList(List<User> userIdList) {
		
		return null;
	}

}
