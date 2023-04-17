package com.employee.service.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document("employee_data")
public class Employee {
	
	@Id
	private String employeeId;
	private String firstName;
	private String lastName;
	private int age;
	private double ctc;
	private String organisation;

}
