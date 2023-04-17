package com.employee.service.services;

import java.util.List;

import org.springframework.messaging.Message;

import com.employee.service.entities.Employee;
import com.employee.service.entities.UpdateMessage;


public interface EmployeeService {
	
	//create Employee
	Employee createEmployee(Employee employee);
	
	//update employee
	Employee UpdateEmployee(Employee employee, String employeeId);
	
	//delete single employee
	void deleteEmployee(String employeeId);
	
	//get single employee detail
	Employee getEmployeeById(String employeeId);
	
	//get all employee details
	List<Employee> getAllEmployee();
	
	//send message to payroll service
	Message<UpdateMessage> sendMessage(UpdateMessage message);
	
}
