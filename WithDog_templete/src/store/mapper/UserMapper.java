package store.mapper;

import java.util.List;

import domain.User;

public interface UserMapper {
	
	boolean createUser(User user);
	
	boolean updateUser(User user);
	
	boolean deleteUser(String userId);
	
	User retrieveUserByUserId(String userId);
	
	List<User> retrieveUserList(List<String> userIdList);
}
