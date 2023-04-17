package com.employee.service.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.employee.service.entities.Employee;

public interface EmployeeRepository extends MongoRepository<Employee, String>{

}
