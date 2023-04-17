package com.employee.service.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.employee.service.entities.Employee;
import com.employee.service.entities.UpdateMessage;
import com.employee.service.services.EmployeeService;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class EmployeeControllerTest {
	
	@Mock
	private EmployeeService employeeService;
	@InjectMocks
	private EmployeeController employeeController;
	private Employee employee;

	@BeforeAll
	void setUpBeforeClass() throws Exception {
		MockitoAnnotations.openMocks(this);
		employee = new Employee("abc","abc","abc",23,23,"abc");
	}

	@Test
	void testCreateEmployee() {
		when(employeeService.createEmployee(employee)).thenReturn(employee);
		assertEquals(23, employeeController.createEmployee(employee).getBody().getAge());
	}

	@Test
	void testGetAllEmployee() {
		List<Employee> lst = new ArrayList<Employee>();
		lst.add(new Employee("abc","abc","abc",23,23,"abc"));
		lst.add(new Employee("abs","abs","abs",25,25,"abs"));
		lst.add(new Employee("abcs","abcs","abcs",26,26,"abcs"));
		lst.add(new Employee("abccs","abccs","abccs",27,27,"abccs"));
		lst.add(new Employee("abxs","abxs","abxs",24,24,"abxs"));
		when(employeeService.getAllEmployee()).thenReturn(lst);
		assertEquals(5, employeeController.getAllEmployee().getBody().size());
	}

	@Test
	void testGetSingleEmployee() {
		when(employeeService.getEmployeeById(Mockito.anyString())).thenReturn(employee);
		assertEquals(23, employeeController.getSingleEmployee(Mockito.anyString()).getBody().getAge());
	}

	 
	@Test
	void testUpdateEmployee() {
		UpdateMessage updateMessage = Mockito.mock(UpdateMessage.class);
		
		
		when(employeeService.UpdateEmployee(employee,"abc")).thenReturn(employee);
	
		assertEquals(23, employeeController.updateEmployee(employee, "abc").getBody().getAge());
	}

	@Test
	void testDeleteEmployee() {
		employeeController.deleteEmployee("abc");
		verify(employeeService).deleteEmployee("abc");
	}

}
