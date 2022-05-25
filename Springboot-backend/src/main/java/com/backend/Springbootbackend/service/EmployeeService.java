package com.backend.Springbootbackend.service;

import java.util.List;
import java.util.Optional;

import com.backend.Springbootbackend.model.Employee;

public interface EmployeeService {
	Employee saveEmployee(Employee employee);
	List<Employee> getAllEmploees();
	Employee getEmployeeById(long id);
	Employee updateEmployee(Employee employee,long id);
	void deleteEmployee(long id);
}
