package com.polleria.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.polleria.entity.Employee;
import com.polleria.repository.EmployeeRepository;
import com.polleria.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public List<Employee> getAll() {
		// TODO Auto-generated method stub
		return employeeRepository.findAll();
	}

	@Override
	public Employee getOneById(Long id) {
		return employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Book Not Found!"));

	}

	@Override
	public Long create(Employee entity) {
		employeeRepository.save(entity);
		return entity.getId();
	}

	@Override
	public void update(Long id, Employee entity) {
		// TODO Auto-generated method stub
		employeeRepository.save(entity);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		employeeRepository.deleteById(id);
	}



	@Transactional(readOnly = true)
	@Override
	public List<Employee> findAll() throws Exception {
		return employeeRepository.findAll();
	}

	@Transactional(readOnly = true)
	@Override
	public List<Employee> fechfindByDni(String dni)  {
		// TODO Auto-generated method stub
		return this.employeeRepository.fechfindByDni(dni);
	}

}
