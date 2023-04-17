package com.employee.service.services.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import com.employee.service.entities.Employee;
import com.employee.service.entities.UpdateMessage;
import com.employee.service.exceptions.ResourceNotFoundException;
import com.employee.service.repository.EmployeeRepository;
import com.employee.service.services.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	@Override
	public Employee createEmployee(Employee employee) {

		return employeeRepository.save(employee);
	}

	@Override
	public Employee UpdateEmployee(Employee employee, String employeeId) {

		Employee existingemployee = employeeRepository.findById(employeeId).orElseThrow(
				() -> new ResourceNotFoundException("User with given Id is not found in server !! " + employeeId));
		existingemployee.setCtc(employee.getCtc());
		return employeeRepository.save(existingemployee);

	}

	@Override
	public void deleteEmployee(String employeeId) {
		employeeRepository.deleteById(employeeId);

	}

	@Override
	public Employee getEmployeeById(String employeeId) {

		return employeeRepository.findById(employeeId).orElseThrow(
				() -> new ResourceNotFoundException("User with given Id is not found in server !! " + employeeId));
	}

	@Override
	public List<Employee> getAllEmployee() {

		return employeeRepository.findAll();
	}

	@Override
	public Message<UpdateMessage> sendMessage(UpdateMessage updateMessage) {
		Message<UpdateMessage> message = MessageBuilder.withPayload(updateMessage)
				.setHeader(KafkaHeaders.TOPIC, "employee_service").build();

		kafkaTemplate.send(message);
		return message;
	}

}
