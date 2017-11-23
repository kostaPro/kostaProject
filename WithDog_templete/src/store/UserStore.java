package store;

import java.util.List;

import domain.User;

public interface UserStore {
	
	boolean createUser(User user);
	boolean updateUser(User user);
	boolean deleteUser(String userId);
	User retrieveUserByUserId(String userId);
	List<User> retrieveUserList(List<User> userIdList);

}
