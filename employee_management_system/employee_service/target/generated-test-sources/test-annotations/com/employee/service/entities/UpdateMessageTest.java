package com.employee.service.entities;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class UpdateMessageTest {

	private UpdateMessage  updateMessage = null;
	
	@BeforeAll
	void setUpBeforeClass() throws Exception {
		updateMessage = new  UpdateMessage();
		
		
		
	}

	@Test
	void testGetEmployeeIdEquals() {
		updateMessage.setEmployeeId("abc");
		assertEquals("abc", updateMessage.getEmployeeId());
	}
	
	@Test
	void testGetEmployeeIdNotNull() {
		updateMessage.setEmployeeId("abc");
		assertNotNull(updateMessage.getEmployeeId());
	}

	@Test
	void testGetCtc() {
		updateMessage.setCtc(23);
		assertEquals(23, updateMessage.getCtc());
	}
	
	@Test
	void testGetCtcNotNull() {
		updateMessage.setCtc(23);
		assertNotNull(updateMessage.getCtc());
	}
	
	@Test
	void testUpdateClassLombok() {
		updateMessage = new UpdateMessage("abc",23);
		assertNotNull(updateMessage.toString());
	}



}
