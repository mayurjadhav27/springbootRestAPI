package com.backend.Springbootbackend.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.backend.Springbootbackend.exception.ResourceNotFoundException;
import com.backend.Springbootbackend.model.Employee;
import com.backend.Springbootbackend.repository.EmployeeRepository;
import com.backend.Springbootbackend.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{

 private 	EmployeeRepository employeeRepository;
 
 
 
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
	super();
	this.employeeRepository = employeeRepository;
}



	@Override
	public Employee saveEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return employeeRepository.save(employee);
	}



	@Override
	public List<Employee> getAllEmploees() {
		// TODO Auto-generated method stub
		return employeeRepository.findAll();
	}



	@Override
	public Employee getEmployeeById(long id) {
		// TODO Auto-generated method stub
		Optional<Employee> employee= employeeRepository.findById(id);
	    if(employee.isPresent())
	    	return employee.get();

		else
			throw new ResourceNotFoundException("Employee","ID",id);
	  
	}



	@Override
	public Employee updateEmployee(Employee employee, long id) {
		// TODO Auto-generated method stub
		Employee existingEmployee=employeeRepository.findById(id).orElseThrow(
				()-> new ResourceNotFoundException("Employee", "ID", id));
		
		existingEmployee.setEmail(employee.getEmail());
		existingEmployee.setFirstName(employee.getFirstName());
		existingEmployee.setLastName(employee.getLastName());
		
		employeeRepository.save(existingEmployee);
		
		
		return existingEmployee;
	}



	@Override
	public void deleteEmployee(long id) {
      
		employeeRepository.findById(id).orElseThrow(
				()-> new ResourceNotFoundException("Employee", "ID", id));
		employeeRepository.deleteById(id);;
		
		
	}
	
	
}
