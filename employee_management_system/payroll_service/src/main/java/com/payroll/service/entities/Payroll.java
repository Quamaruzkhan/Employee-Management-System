package com.payroll.service.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Document("payroll_data")
public class Payroll {
	
	@Id
	private String payrollId;
	private String employeeId;
	private String registeredBank;
	private String bankAccountNumber;
	private double monthlySalary;
	

}
