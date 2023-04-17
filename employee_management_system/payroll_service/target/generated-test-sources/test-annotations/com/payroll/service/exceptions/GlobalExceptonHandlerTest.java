package com.payroll.service.exceptions;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;



@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class GlobalExceptonHandlerTest {

	private GlobalExceptonHandler exceptonHandler;

	@BeforeAll
	void setUpBeforeClass() throws Exception {
		exceptonHandler = new GlobalExceptonHandler();
	}

	@Test
	void testHandlerResourceNotFoundException() {
		ResourceNotFoundException exception = new ResourceNotFoundException("abc");
		assertEquals("abc", exceptonHandler.handlerResourceNotFoundException(exception).getBody().getMessage());
	}

}
