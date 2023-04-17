package com.payroll.service.entities;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class PayrollTest {
	
	private Payroll payroll;

	@BeforeAll
	void setUpBeforeClass() throws Exception {
		payroll = new Payroll();
		payroll = new  Payroll("abc", "abc", "abc", "abc", 24);
		String message = payroll.toString();
	}

	@Test
	void testGetPayrollId() {
		payroll.setPayrollId("def");
		assertEquals("def", payroll.getPayrollId());
	}

	@Test
	void testGetEmployeeId() {
		payroll.setEmployeeId("def");
		assertEquals("def", payroll.getEmployeeId());
	}

	@Test
	void testGetRegisteredBank() {
		payroll.setRegisteredBank("def");
		assertEquals("def", payroll.getRegisteredBank());
	}

	@Test
	void testGetBankAccountNumber() {
		payroll.setBankAccountNumber("def");
		assertEquals("def", payroll.getBankAccountNumber());
	}

	@Test
	void testGetMonthlySalary() {
		payroll.setMonthlySalary(24);
		assertEquals(24, payroll.getMonthlySalary());
	}

}
