package com.payroll.service.services.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.payroll.service.entities.Payroll;
import com.payroll.service.entities.UpdateMessage;
import com.payroll.service.repository.PayrollRepository;
import com.payroll.service.services.PayrollService;

@Service
public class PayrollServiceImpl implements PayrollService {

	private static final Logger LOGGER = LoggerFactory.getLogger(PayrollServiceImpl.class);

	@Autowired
	private PayrollRepository payrollRepository;

	@Override
	public Payroll createEmployeePayroll(Payroll employeePayroll) {

		return payrollRepository.save(employeePayroll);
	}

	@Override
	public Payroll updateEmployeePayroll(String employeeId, double ctc) {

		Payroll payroll = payrollRepository.findByEmployeeId(employeeId);
		payroll.setMonthlySalary(ctc / 12);

		return payrollRepository.save(payroll);
	}

	@Override
	public void deleteEmployeePayroll(String employeeId) {
		payrollRepository.deleteById(employeeId);

	}

	@Override
	public Payroll getEmployeePayrollById(String employeeId) {

		return payrollRepository.findByEmployeeId(employeeId);
	}

	@Override
	public List<Payroll> getAllEmployeePayroll() {

		return payrollRepository.findAll();
	}

	@KafkaListener(topics = "employee_service", groupId = "payrollGroup")
	public void messageConsume(String messageReceived) {
		ObjectMapper mapper = new ObjectMapper();
		UpdateMessage updateMessage = null;
		try {
			updateMessage = mapper.readValue(messageReceived, UpdateMessage.class);

		} catch (JsonProcessingException e) {

			e.printStackTrace();
		}

		updateEmployeePayroll(updateMessage.getEmployeeId(), updateMessage.getCtc());

	}

}
