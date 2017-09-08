package hr.store.mapper;

import java.util.List;

import hr.domain.Department;

public interface DepartmentMapper {

	List<Department> retrieveAll();

	void create(Department department);

	Department retrieve(String deptNo);

	void delete(String deptNo);
}
