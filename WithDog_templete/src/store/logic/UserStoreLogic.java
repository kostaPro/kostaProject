package store.logic;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import domain.User;
import store.UserStore;
import store.factory.SqlSessionFactoryProvider;

@Repository
public class UserStoreLogic implements UserStore{
	
	private SqlSessionFactory factory;
	
	public UserStoreLogic() {
		factory = SqlSessionFactoryProvider.getSqlSessionFactory();
	}

	@Override
	public boolean createUser(User user) {
		
		SqlSession session = factory.openSession();

		try {
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			session.close();
		}
		
		return false;
	}

	@Override
	public boolean updateUser(User user) {
		
		SqlSession session = factory.openSession();

		try {
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			session.close();
		}
		
		return false;
	}

	@Override
	public boolean deleteUser(String userId) {
		
		SqlSession session = factory.openSession();

		try {
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			session.close();
		}
	
		return false;
	}

	@Override
	public User retrieveUserByUserId(String userId) {
		
		SqlSession session = factory.openSession();

		try {
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			session.close();
		}
		
		return null;
	}

	@Override
	public List<User> retrieveUserList(List<User> userIdList) {
		
		SqlSession session = factory.openSession();

		try {
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			session.close();
		}
		
		return null;
	}

}
