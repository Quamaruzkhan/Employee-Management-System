package com.payroll.service.exceptions;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;



class ResourceNotFoundExceptionTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@Test
	void test() {
		ResourceNotFoundException resourceNotFoundException = new ResourceNotFoundException();
		ResourceNotFoundException exception = new ResourceNotFoundException("abc");
		
	}
}
