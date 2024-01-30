package com.practice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.entity.Employee;
import com.practice.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Employee saveEmployee(Employee employee) {
		
		return employeeRepository.save(employee);
	}

	@Override
	public Employee getEmployeeById(int eid) {
		
		return employeeRepository.findById(eid).get();
	}

	@Override
	public List<Employee> getAllEmployee() {
		
		return employeeRepository.findAll();
	}

	@Override
	public Employee updateEmployee(Employee employee) {
	
		return employeeRepository.save(employee);
	}

	@Override
	public void deleteEmployeeById(int eid) {
	
		employeeRepository.deleteById(eid);
		
	}

}
