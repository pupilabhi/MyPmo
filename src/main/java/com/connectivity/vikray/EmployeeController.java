package com.connectivity.vikray;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
	
	@Autowired
	EmployeeRepository repository;
	
	@GetMapping("/employee/all")
	public List<Employee> getEmployee(){
		return repository.findAll();
	}
	
}
