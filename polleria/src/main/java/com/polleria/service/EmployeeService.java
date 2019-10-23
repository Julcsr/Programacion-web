package com.polleria.service;

import java.util.List;
import java.util.Optional;

import com.polleria.entity.Employee;

public interface EmployeeService extends CrudService<Employee, Long> {
	public List<Employee> fechfindByDni(String dni);
}
