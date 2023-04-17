package com.employee.service.services.impl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;

import com.employee.service.entities.Employee;
import com.employee.service.entities.UpdateMessage;
import com.employee.service.exceptions.ResourceNotFoundException;
import com.employee.service.repository.EmployeeRepository;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(OrderAnnotation.class)
class EmployeeServiceImplTest {

	
	private Employee employee = null;
	private Optional<Employee> employee2 = null;
	
	@Mock
	private EmployeeRepository employeeRepository;
	@Mock
	private KafkaTemplate<String, String> kafkaTemplate;
	@InjectMocks
	private EmployeeServiceImpl employeeServiceImpl;
	
	@BeforeAll
	void setUpBeforeClass() throws Exception {
		MockitoAnnotations.openMocks(this);
		employee = new Employee("abc","abc","abc",23,23,"abc");
		employee2 = Optional.ofNullable(new Employee("abcd","abcd","abcd",25,25,"abcd"));
	}

	@Test
	void testCreateEmployee() {
		when(employeeRepository.save(Mockito.any(Employee.class))).thenReturn(employee);
		assertEquals(23, employeeServiceImpl.createEmployee(employee).getAge());
		
	}

	@Test
	@Order(2)
	void testUpdateEmployee() {
		when(employeeRepository.findById(Mockito.anyString())).thenReturn(employee2);
		when(employeeRepository.save(Mockito.any(Employee.class))).thenReturn(employee);
		assertEquals(23, employeeServiceImpl.UpdateEmployee(employee, "abcd").getAge());
	}
	
	@Test
	@Order(1)
	void testUpdateEmployeeException() {
		//when(employeeRepository.findById(Mockito.anyString())).thenThrow(new ResourceNotFoundException("User with given Id is not found in server !! abc"));
		Exception exception = assertThrows(ResourceNotFoundException.class, ()->{
			employeeServiceImpl.UpdateEmployee(employee, "abc");
		});
		assertTrue(exception.getMessage().contains("User with given Id is not found in server !! abc"));
	}

	@Test
	void testDeleteEmployee() {
		employeeServiceImpl.deleteEmployee("abc");
		verify(employeeRepository).deleteById("abc");
		
	}

	@Test
	@Order(2)
	void testGetEmployeeById() {
		when(employeeRepository.findById(Mockito.anyString())).thenReturn(employee2);
		assertEquals(25, employeeServiceImpl.getEmployeeById("abc").getAge());
	}
	
	@Test
	@Order(1)
	void testGetEmployeeByIdException() {
		Exception exception = assertThrows(ResourceNotFoundException.class, ()->{
			employeeServiceImpl.getEmployeeById("abc");
		});
		assertTrue(exception.getMessage().contains("User with given Id is not found in server !! abc"));
	}

	@Test
	void testGetAllEmployee() {
		List<Employee> lst = new ArrayList<Employee>();
		lst.add(new Employee("abc","abc","abc",23,23,"abc"));
		lst.add(new Employee("abs","abs","abs",25,25,"abs"));
		lst.add(new Employee("abcs","abcs","abcs",26,26,"abcs"));
		lst.add(new Employee("abccs","abccs","abccs",27,27,"abccs"));
		lst.add(new Employee("abxs","abxs","abxs",24,24,"abxs"));
		when(employeeRepository.findAll()).thenReturn(lst);
		assertEquals(25, employeeServiceImpl.getAllEmployee().get(1).getAge());
		
	}

	@Test
	void testSendMessage() {
		
		
		UpdateMessage updateMessage=new UpdateMessage();
    	updateMessage.setCtc(23);
    	updateMessage.setEmployeeId("abc");
    	Message<UpdateMessage> message = employeeServiceImpl.sendMessage(updateMessage);
    	Mockito.verify(kafkaTemplate, atLeastOnce()).send(message);
	}

}
