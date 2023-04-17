package com.payroll.service.controller;

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

import com.payroll.service.entities.Payroll;
import com.payroll.service.services.PayrollService;

@RestController
@RequestMapping("/payroll")
public class PayrollServiceController {
	
	@Autowired
	private PayrollService payrollService;
	//create
		@PostMapping
		public ResponseEntity<Payroll> createEmployeePayroll(@RequestBody Payroll employeepayroll){
			Payroll savedEmployeePayroll = payrollService.createEmployeePayroll(employeepayroll);
			return ResponseEntity.status(HttpStatus.CREATED).body(savedEmployeePayroll);
			
		}
		
		//get all user
		@GetMapping
		public ResponseEntity<List<Payroll>> getAllEmployeePayroll(){
			List<Payroll> employees = payrollService.getAllEmployeePayroll();
			return ResponseEntity.ok(employees);
		}
		
		//get user by id
		@GetMapping("/{employeeId}")
		public ResponseEntity<Payroll> getSingleEmployeePayroll(@PathVariable String employeeId){
			Payroll employeePayroll = payrollService.getEmployeePayrollById(employeeId);
			return ResponseEntity.ok(employeePayroll);
			
		}
		
		
		//delete user
		@DeleteMapping("/{employeeId}")
		public void deleteEmployee(@PathVariable String employeeId) {
			payrollService.deleteEmployeePayroll(employeeId);
		}


}
