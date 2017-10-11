package hr.store.logic;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import hr.domain.Department;
import hr.store.DepartmentStore;
import hr.store.mapper.DepartmentMapper;

public class DepartmentStoreLogic implements DepartmentStore{

	private SqlSessionFactory factory;
	
	public DepartmentStoreLogic() {
		factory = SqlSessionFactoryProvider.getSqlSessionFactory();
	}
	@Override
	public List<Department> retrieveAll() {
		SqlSession session = factory.openSession();
		List<Department> list = null;
		
		try {
			DepartmentMapper mapper = session.getMapper(DepartmentMapper.class);
			list = mapper.retrieveAll();
		}catch(Exception e) {
			throw new RuntimeException(e);
		}finally {
			session.close();
		}
		return list;
	}

	@Override
	public void create(Department department) {
		SqlSession session = factory.openSession();
		
		try {
			DepartmentMapper mapper = session.getMapper(DepartmentMapper.class);
			mapper.create(department);
			session.commit();
		}catch(Exception e) {
			throw new RuntimeException(e);
		}finally {
			session.close();
		}
	}

	@Override
	public Department retrieve(String deptNo) {
		SqlSession session = factory.openSession();
		Department department = null;
		
		try {
			DepartmentMapper mapper = session.getMapper(DepartmentMapper.class);
			department = mapper.retrieve(deptNo);
		}catch(Exception e) {
			throw new RuntimeException(e);
		}finally {
			session.close();
		}
		return department;
	}

	@Override
	public void delete(String deptNo) {
		SqlSession session = factory.openSession();
		
		try {
			DepartmentMapper mapper = session.getMapper(DepartmentMapper.class);
			mapper.delete(deptNo);
			session.commit();
		}catch(Exception e) {
			throw new RuntimeException(e);
		}finally {
			session.close();
		}
	}

}
