package service;

import java.util.List;

import domain.User;

public interface UserService {
	
	boolean registUser(User user);
	boolean modifyUser(User user);
	boolean removeUser(String userId);
	User findUserByUserId(String userId);
	List<User> findUserList(List<User> userIdList);

}
