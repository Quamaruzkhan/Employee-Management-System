package com.payroll.service.services;

import java.util.List;

import com.payroll.service.entities.Payroll;


public interface PayrollService {

	//create Employee payroll
	Payroll createEmployeePayroll(Payroll employee);
	
	//update employee payroll
	Payroll updateEmployeePayroll(String employeeId, double ctc);
	
	//delete employee
	void deleteEmployeePayroll(String employeeId);
	
	//get single employee payroll
	Payroll getEmployeePayrollById(String employeeId);
	
	//get all employee payroll
	List<Payroll> getAllEmployeePayroll();

}
