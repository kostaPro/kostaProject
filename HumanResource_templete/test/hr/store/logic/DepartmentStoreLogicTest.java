package hr.store.logic;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import hr.domain.Department;
import hr.store.DepartmentStore;

public class DepartmentStoreLogicTest {
	private DepartmentStore store;
	
	@Before
	public void setUp() {
		store = new DepartmentStoreLogic();
	}

	@Test
	public void testRetrieveAll() {
		List<Department> list = store.retrieveAll();
		assertNotNull(list);
		assertEquals(2, list.size());
		assertEquals("영업부", list.get(0).getName());
		assertEquals(2, list.get(1).getEmployees().size());
		assertEquals("mei", list.get(1).getEmployees().get(1).getName());
	}

	@Test
	public void testCreate() {
//		Department department = new Department("3", "인사부");
//		store.create(department);
	}

	@Test
	public void testRetrieve() {
		Department dep = store.retrieve("2");
		assertNotNull(dep);
		assertEquals("인사부", dep.getName());
		assertEquals(2, dep.getEmployees().size());
		assertEquals("jin", dep.getEmployees().get(0).getName());
	}

	@Test
	public void testDelete() {
//		store.delete("3");
	}

}
