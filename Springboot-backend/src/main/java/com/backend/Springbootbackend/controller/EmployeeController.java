package com.backend.Springbootbackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.Springbootbackend.model.Employee;
import com.backend.Springbootbackend.service.EmployeeService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

	private EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}
	
	@PostMapping()
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){
		return new ResponseEntity<Employee>(employeeService.saveEmployee(employee),HttpStatus.CREATED);
	}
	
	//get all emps rest api
	@GetMapping()
	public List<Employee> getAllEmployees(){
		return employeeService.getAllEmploees();
	}
	
	//get by id
	@GetMapping("/{id}")
	public ResponseEntity<Employee> getById (@PathVariable long id) {
		return new ResponseEntity(employeeService.getEmployeeById(id),HttpStatus.OK);
	}
	@PutMapping("{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable long id,@RequestBody Employee employee){
	  return new ResponseEntity<Employee>(employeeService.updateEmployee(employee, id), HttpStatus.OK);	
	}
	
	@DeleteMapping("{id}")
	public  ResponseEntity<String> deleteById(@PathVariable long id){
		employeeService.deleteEmployee(id);
		return new ResponseEntity<String>( "Employee deleted Successfully",HttpStatus.OK);
	}
}
