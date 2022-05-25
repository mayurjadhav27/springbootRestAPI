package com.backend.Springbootbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.Springbootbackend.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
