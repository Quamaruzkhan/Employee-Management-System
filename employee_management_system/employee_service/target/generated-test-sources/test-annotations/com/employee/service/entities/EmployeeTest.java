package com.employee.service.entities;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class EmployeeTest {
	
	private Employee employee = null;

	@BeforeAll
	void setUpBeforeClass() throws Exception {
		employee = new Employee();	}

	@Test
	void testGetEmployeeIdEquals() {
		employee.setEmployeeId("abc");
		assertEquals("abc", employee.getEmployeeId());
	}
	
	@Test
	void testGetEmployeeIdNotEquals() {
		employee.setEmployeeId("abc");
		assertNotEquals("abd",employee.getEmployeeId());
	}

	@Test
	void testGetFirstNameEquals() {
		employee.setFirstName("khan");
		assertEquals("khan", employee.getFirstName());
	}
	@Test
	void testGetFirstNameNotEquals() {
		employee.setFirstName("khan");
		assertNotEquals("khaan", employee.getFirstName());
	}

	@Test
	void testGetLastNameEquals() {
		employee.setLastName("khan");
		assertEquals("khan", employee.getLastName());
	}
	
	@Test
	void testGetLastNameNotEquals() {
		employee.setLastName("khan");
		assertNotEquals("khaan", employee.getLastName());
	}

	@Test
	void testGetAgeEquals() {
		employee.setAge(23);
		assertEquals(23, employee.getAge());
	}
	
	@Test
	void testGetAgeNotEquals() {
		employee.setAge(23);
		assertNotEquals(24, employee.getAge());
	}

	@Test
	void testGetCtcEquals() {
		employee.setCtc(23);
		assertEquals(23, employee.getCtc());
	}
	@Test
	void testGetCtcEqualsNotEquals() {
		employee.setCtc(23);
		assertNotEquals(24, employee.getCtc());
	}

	@Test
	void testGetOrganisationEquals() {
		employee.setOrganisation("accenture");
		assertEquals("accenture", employee.getOrganisation());
	
	}
	@Test
	void testGetOrganisationNotEquals() {
		employee.setOrganisation("accenture");
		assertNotEquals("abc", employee.getOrganisation());
	
	}

	@Test
	void testEmployeeNoArgConstructor() {
		assertNotNull(new Employee());
	}

	@Test
	void testEmployeeAllargConstructor() {
		assertNotNull(new Employee("abc","abc","abc",21,23,"abc"));
	}

}
