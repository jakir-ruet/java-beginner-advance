package com.employeeapp.empmanagement.service.impl;

import org.springframework.stereotype.Service;

import com.employeeapp.empmanagement.dto.EmployeeDto;
import com.employeeapp.empmanagement.repository.EmployeeRepository;
import com.employeeapp.empmanagement.service.EmployeeService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor

public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepository employeeRepository;

	public EmployeeDto createEmployee(EmployeeDto employeeDto) {
		// TODO Auto-generated method stub
		return null;
	}
}
