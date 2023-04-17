package com.payroll.service.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.payroll.service.entities.Payroll;

@Repository
public interface PayrollRepository extends MongoRepository<Payroll, String> {
	
	//custom finder methods
	Payroll findByEmployeeId(String employeeId);

}
