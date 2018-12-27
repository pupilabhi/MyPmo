package com.connectivity.vikray.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.connectivity.vikray.Employee;
import com.connectivity.vikray.repository.UserDetailsRepository;

@RestController
public class UserController {

	@Autowired
	UserDetailsRepository repository;
	
	@GetMapping("/user/details")
	public List<UserDetailsRepository> getEmployee(){
		return repository.findAll();
	}
}
