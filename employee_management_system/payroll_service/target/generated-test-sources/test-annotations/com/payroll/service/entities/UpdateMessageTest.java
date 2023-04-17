package com.payroll.service.entities;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class UpdateMessageTest {

	private UpdateMessage updateMessage;
	@BeforeAll
	void setUpBeforeClass() throws Exception {
		updateMessage = new UpdateMessage();
		updateMessage = new UpdateMessage("abc", 24);
		String message = updateMessage.toString();
	}

	@Test
	void testGetEmployeeId() {
		updateMessage.setEmployeeId("def");
		assertEquals("def", updateMessage.getEmployeeId());
	}

	@Test
	void testGetCtc() {
		updateMessage.setCtc(25);
		assertEquals(25, updateMessage.getCtc());
	}

}
