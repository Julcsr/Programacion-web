package com.polleria.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.polleria.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

	@Query(value="SELECT * FROM employees WHERE employee_dni=?",nativeQuery = true)
	public List<Employee> fechfindByDni(String dni);
	
	
	//List<Employee> findByDni(String dni);
	
}
