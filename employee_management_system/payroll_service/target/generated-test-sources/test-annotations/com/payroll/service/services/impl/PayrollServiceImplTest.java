package com.payroll.service.services.impl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.payroll.service.controller.PayrollServiceController;
import com.payroll.service.entities.Payroll;
import com.payroll.service.entities.UpdateMessage;
import com.payroll.service.repository.PayrollRepository;
import com.payroll.service.services.PayrollService;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(OrderAnnotation.class)
class PayrollServiceImplTest {
	
	@Mock
	private PayrollRepository payrollRepository;
	@InjectMocks
	private PayrollServiceImpl payrollServiceImpl;
	private Payroll payroll;
	private Optional<Payroll> payroll2;

	@BeforeAll
	void setUpBeforeClass() throws Exception {
		MockitoAnnotations.openMocks(this);
		payroll = new Payroll("abc","abc","abc","abc", 12);
		payroll2 = Optional.ofNullable(new Payroll("abcd","abcd","abcd","abcd", 25));
	}

	@Test
	void testCreateEmployeePayroll() {
		when(payrollRepository.save(Mockito.any(Payroll.class))).thenReturn(payroll);
		assertEquals(12, payrollServiceImpl.createEmployeePayroll(payroll).getMonthlySalary());
	}

	@Test
	void testUpdateEmployeePayroll() {
		when(payrollRepository.findByEmployeeId(Mockito.anyString())).thenReturn(payroll);
		when(payrollRepository.save(Mockito.any(Payroll.class))).thenReturn(payroll);
		assertEquals(12, payrollServiceImpl.updateEmployeePayroll("abcd", 144).getMonthlySalary());
	}

	@Test
	void testDeleteEmployeePayroll() {
		payrollServiceImpl.deleteEmployeePayroll("abc");
		verify(payrollRepository).deleteById("abc");
	}

	@Test
	void testGetEmployeePayrollById() {
		when(payrollRepository.findByEmployeeId(Mockito.anyString())).thenReturn(payroll);
		assertEquals(12, payrollServiceImpl.getEmployeePayrollById("abc").getMonthlySalary());
	}

	@Test
	void testGetAllEmployeePayroll() {
		List<Payroll> lst = new ArrayList<Payroll>();
		lst.add(new Payroll("abc","abc","abc","abc", 12));
		lst.add(new Payroll("abcd","abcd","abc","abc", 24));
		lst.add(new Payroll("abcde","abcdt","abct","abct", 36));
		lst.add(new Payroll("abcdt","abcdt","abct","abct", 48));
		lst.add(new Payroll("abcdb","abcdb","abcb","abcb", 64));
		when(payrollRepository.findAll()).thenReturn(lst);
		assertEquals(24, payrollServiceImpl.getAllEmployeePayroll().get(1).getMonthlySalary());
	}

//	@Test
//	void testMessageConsume() throws JsonProcessingException {
//		ObjectMapper mapper = new ObjectMapper();
//		UpdateMessage updateMessage = new  UpdateMessage("abc", 24);
//		String message = mapper.writeValueAsString(updateMessage);
//		do().when(payrollServiceImpl.updateEmployeePayroll("abc", 23));
//		payrollServiceImpl.messageConsume(message);
//		
//	}

}
