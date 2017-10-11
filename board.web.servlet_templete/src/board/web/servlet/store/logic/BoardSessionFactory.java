package board.web.servlet.store.logic;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class BoardSessionFactory {
	private static BoardSessionFactory instance;
	private static SqlSessionFactory sqlSessionFactory;
	private static final String resource = "mybatis-config.xml";
	
	private BoardSessionFactory() {
	}
	
	public static BoardSessionFactory getInstance() {
		if(instance == null) {
			instance = new BoardSessionFactory();
		}
		
		return instance;
	}
	
	public SqlSession getSession() {
		if(sqlSessionFactory == null) {
			Reader reader = null;
			try {
				reader = Resources.getResourceAsReader(resource);
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
			
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		}
		return sqlSessionFactory.openSession();
	}
}
