package hr.store.logic;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import hr.domain.Employee;
import hr.store.EmployeeStore;
import hr.store.mapper.EmployeeMapper;

public class EmployeeStoreLogic implements EmployeeStore{

	private SqlSessionFactory factory;
	
	public EmployeeStoreLogic() {
		factory = SqlSessionFactoryProvider.getSqlSessionFactory();
	}
	
	@Override
	public List<Employee> retrieveAll() {
		SqlSession session = factory.openSession();
		List<Employee> list = null;
		
		try {
			EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
			list = mapper.retrieveAll();
		}catch(Exception e) {
			throw new RuntimeException(e);
		}
		finally {
			session.close();
		}
		return list;
	}

	@Override
	public void create(Employee employee) {
		SqlSession session = factory.openSession();
		
		try {
			EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
			mapper.create(employee);
			session.commit();
		}catch(Exception e) {
			throw new RuntimeException(e);
		}finally {
			session.close();
		}
	}

	@Override
	public List<Employee> retrieveByDeptNo(String deptNo) {
		SqlSession session = factory.openSession();
		List<Employee> employees = null;
		
		try {
			EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
			employees = mapper.retrieveByDeptNo(deptNo);
		}catch(Exception e) {
			throw new RuntimeException(e);
		}finally {
			session.close();
		}
		return employees;
	}

	@Override
	public void update(Employee employee) {
		SqlSession session = factory.openSession();
		
		try {
			EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
			mapper.update(employee);
			session.commit();
		}catch(Exception e) {
			throw new RuntimeException(e);
		}finally {
			session.close();
		}
	}

	@Override
	public Employee retrieve(String empNo) {
		SqlSession session = factory.openSession();
		Employee employee = null;
		
		try {
			EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
			employee = mapper.retrieve(empNo);
		}catch(Exception e) {
			throw new RuntimeException(e);
		}finally {
			session.close();
		}
		return employee;
	}

}
