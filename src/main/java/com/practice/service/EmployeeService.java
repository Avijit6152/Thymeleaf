package com.practice.service;

import java.util.List;

import com.practice.entity.Employee;



public interface EmployeeService {
	
	public	Employee saveEmployee(Employee employee);
	
	public 	Employee getEmployeeById(int eid);
	public 	List<Employee> getAllEmployee();
		
	public	Employee updateEmployee(Employee employee);

	public void deleteEmployeeById(int eid);

}
