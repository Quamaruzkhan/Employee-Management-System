package com.employee.service.controller;

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

import com.employee.service.entities.Employee;
import com.employee.service.entities.UpdateMessage;
import com.employee.service.services.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	// create
	@PostMapping
	public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
		Employee savedEmployee = employeeService.createEmployee(employee);
		return ResponseEntity.status(HttpStatus.CREATED).body(savedEmployee);

	}

	// get all user
	@GetMapping
	public ResponseEntity<List<Employee>> getAllEmployee() {
		List<Employee> employees = employeeService.getAllEmployee();
		return ResponseEntity.ok(employees);
	}

	// get user by id
	@GetMapping("/{employeeId}")
	public ResponseEntity<Employee> getSingleEmployee(@PathVariable String employeeId) {
		Employee employee = employeeService.getEmployeeById(employeeId);
		return ResponseEntity.ok(employee);

	}

	// update user by id
	@PutMapping("/{employeeId}")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee, @PathVariable String employeeId) {

		UpdateMessage updateMessage = new UpdateMessage();

		Employee updatedEmployee = employeeService.UpdateEmployee(employee, employeeId);

		updateMessage.setEmployeeId(updatedEmployee.getEmployeeId());
		updateMessage.setCtc(updatedEmployee.getCtc());

		employeeService.sendMessage(updateMessage);

		return ResponseEntity.status(HttpStatus.CREATED).body(updatedEmployee);

	}

	// delete user
	@DeleteMapping("/{employeeId}")
	public void deleteEmployee(@PathVariable String employeeId) {
		employeeService.deleteEmployee(employeeId);
	}

}
