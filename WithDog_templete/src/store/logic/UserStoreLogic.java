package store.logic;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import domain.User;
import store.UserStore;
import store.factory.SqlSessionFactoryProvider;
import store.mapper.UserMapper;

@Repository
public class UserStoreLogic implements UserStore {

	private SqlSessionFactory factory;

	public UserStoreLogic() {
		factory = SqlSessionFactoryProvider.getSqlSessionFactory();
	}

	@Override
	public boolean createUser(User user) {

		SqlSession session = factory.openSession();

		boolean result = false;
		
		try {
			UserMapper mapper = session.getMapper(UserMapper.class);
			result = mapper.createUser(user);
			
			if(result) {
				session.commit();
			}else {
				session.rollback();
			}
		
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			session.close();
		}

		return result;
	}

	@Override
	public boolean updateUser(User user) {

		SqlSession session = factory.openSession();
		
		boolean result = false;
		
		try {
			UserMapper mapper = session.getMapper(UserMapper.class);
			result = mapper.updateUser(user);
			
			if(result) {
				session.commit();
			}else {
				session.rollback();
			}
		
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			session.close();
		}

		return result;
	}

	@Override
	public boolean deleteUser(String userId) {

		SqlSession session = factory.openSession();

		boolean result = false;
		
		try {
			UserMapper mapper = session.getMapper(UserMapper.class);
			result = mapper.deleteUser(userId);
		
			if(result) {
				session.commit();
			}else {
				session.rollback();
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			session.close();
		}

		return result;
	}

	@Override
	public User retrieveUserByUserId(String userId) {

		SqlSession session = factory.openSession();
		User user = new User();
		try {
			UserMapper mapper = session.getMapper(UserMapper.class);
			user = mapper.retrieveUserByUserId(userId);
		
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			session.close();
		}

		return user;
	}

	@Override
	public List<User> retrieveUserList(List<String> userIdList) {

		SqlSession session = factory.openSession();
		List<User> userList = new ArrayList<>();
		try {
			UserMapper mapper = session.getMapper(UserMapper.class);
			userList = mapper.retrieveUserList(userIdList);
		
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			session.close();
		}

		return userList;
	}

}
