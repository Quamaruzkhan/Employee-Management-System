package com.payroll.service.controller;

import static org.junit.jupiter.api.Assertions.*;
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


import com.payroll.service.entities.Payroll;
import com.payroll.service.services.PayrollService;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class PayrollServiceControllerTest {
	
	@Mock
	private PayrollService payrollService;
	@InjectMocks
	private PayrollServiceController payrollServiceController;
	private Payroll payroll;

	@BeforeAll
	void setUpBeforeClass() throws Exception {
		MockitoAnnotations.openMocks(this);
		payroll = new Payroll("abc","abc","abc", "abc",23);
	}

	@Test
	void testCreateEmployeePayroll() {
		when(payrollService.createEmployeePayroll(payroll)).thenReturn(payroll);
		assertEquals(23, payrollServiceController.createEmployeePayroll(payroll).getBody().getMonthlySalary());
	}

	@Test
	void testGetAllEmployeePayroll() {
		List<Payroll> lst = new ArrayList<Payroll>();
		lst.add(new Payroll("abc","abc","abc", "abc",23));
		lst.add(new Payroll("abs","abs","abc", "abc",23));
		lst.add(new Payroll("abcs","abcs","abc", "abc",23));
		lst.add(new Payroll("abccs","abccs","abc", "abc",23));
		lst.add(new Payroll("abxs","abxs","abc", "abc",23));
		when(payrollService.getAllEmployeePayroll()).thenReturn(lst);
		assertEquals(5, payrollServiceController.getAllEmployeePayroll().getBody().size());
	}

	@Test
	void testGetSingleEmployeePayroll() {
		when(payrollService.getEmployeePayrollById(Mockito.anyString())).thenReturn(payroll);
		assertEquals(23, payrollServiceController.getSingleEmployeePayroll(Mockito.anyString()).getBody().getMonthlySalary());
	}

	@Test
	void testDeleteEmployee() {
		payrollServiceController.deleteEmployee("abc");
		verify(payrollService).deleteEmployeePayroll("abc");
	}

}
