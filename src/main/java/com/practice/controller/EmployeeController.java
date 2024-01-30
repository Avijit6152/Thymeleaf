package com.practice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.practice.entity.Employee;
import com.practice.service.EmployeeServiceImpl;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeServiceImpl employeeServiceImpl;
	
	@GetMapping("/employee")
	public String listEmployee(Model model) {
		
		model.addAttribute("employee", employeeServiceImpl.getAllEmployee());
		return "employee";
		}
	
	
	@GetMapping("/employee/create")
	public String createEmployee(Model model) {
		
		Employee empl=new Employee();
		model.addAttribute("employee", empl);
		return "create_employee";
	}
	
	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("employee") Employee employee) {
		
		employeeServiceImpl.saveEmployee(employee);
		
		return "redirect:/employee";
		
	}
	
	@GetMapping("/edit/{eid}")
	public String editEmployee(@PathVariable int eid, Model model) {
		
		model.addAttribute("employee", employeeServiceImpl.getEmployeeById(eid));
		return "edit_employee";
		
	}
	
	@PostMapping("/employee/{eid}")
	public String updateEmployee(@PathVariable int eid,
			@ModelAttribute("employee") Employee employee, 
			Model model) {
		
		//get Employee from database by id
		
	  Employee existingEmployee	= employeeServiceImpl.getEmployeeById(eid);
	  existingEmployee.setEid(eid);
	  existingEmployee.setEname(employee.getEname());
	  existingEmployee.setEsal(employee.getEsal());
	  existingEmployee.setDeptno(employee.getDeptno());
	  
	  
	  //Save updated employee object
	  
	  employeeServiceImpl.updateEmployee(existingEmployee);
	  return "redirect:/employee";
	  
		
	}
	
	@GetMapping("/delete/{eid}")
	public String deleteEmployee(@PathVariable int eid) {
		
		employeeServiceImpl.deleteEmployeeById(eid);
		return "redirect:/employee";
		
	}
	
	@GetMapping("/view/{eid}")
	public String viewEmployee(@PathVariable int eid, Model model) {
		
		model.addAttribute("employee", employeeServiceImpl.getEmployeeById(eid));
		
		return "view_employee";
	}
}
