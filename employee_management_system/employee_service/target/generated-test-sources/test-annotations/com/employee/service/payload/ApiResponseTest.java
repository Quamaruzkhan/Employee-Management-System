package com.employee.service.payload;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.http.HttpStatus;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ApiResponseTest {
	
	private ApiResponse apiResponse;

	@BeforeAll
	void setUpBeforeClass() throws Exception {
		apiResponse = new ApiResponse();
		apiResponse = new ApiResponse("abc", false, HttpStatus.BAD_REQUEST);
		apiResponse = ApiResponse.builder().message("abc").success(true).status(HttpStatus.NOT_FOUND).build();
	}

	@Test
	void testGetMessage() {
		apiResponse.setMessage("abc");
		assertEquals("abc", apiResponse.getMessage());
	}

	@Test
	void testIsSuccess() {
		apiResponse.setSuccess(true);
		assertTrue(apiResponse.isSuccess());
	}

	@Test
	void testGetStatus() {
		apiResponse.setStatus(HttpStatus.ACCEPTED);
		assertEquals(HttpStatus.ACCEPTED, apiResponse.getStatus());
	}

}
