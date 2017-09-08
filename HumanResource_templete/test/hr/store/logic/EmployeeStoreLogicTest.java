package hr.store.logic;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import hr.domain.Employee;
import hr.store.EmployeeStore;

public class EmployeeStoreLogicTest {

	private EmployeeStore store;
	
	@Before
	public void setUp() {
		store = new EmployeeStoreLogic();
	}
	@Test
	public void testRetrieveAll() {
		List<Employee> list = store.retrieveAll();
		
		assertNotNull(list);
		assertEquals(2, list.size());
		
		assertEquals("kim", list.get(1).getName());
	}

	@Test
	public void testCreate() {
		Employee employee = new Employee();
		
		employee.setNo("3");
		employee.setName("jin");
		employee.setDeptNo("3");
		
		store.create(employee);
	}

	@Test
	public void testRetrieveByDeptNo() {
		List<Employee> list = store.retrieveByDeptNo("1");
		
		assertNotNull(list);
		assertEquals(2, list.size());
		
		assertEquals("kim", list.get(1).getName());
	}

	@Test
	public void testUpdate() {
		Employee emp = store.retrieve("1");
		emp.setDeptNo("2");
		store.update(emp);
	}

	@Test
	public void testRetrieve() {
		Employee emp = store.retrieve("1");
		
		assertNotNull(emp);
		assertEquals("mei", emp.getName());
	}

}
