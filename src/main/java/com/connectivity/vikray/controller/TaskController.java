package com.connectivity.vikray.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.connectivity.vikray.entity.Task;
import com.connectivity.vikray.pojo.ValidResult;
import com.connectivity.vikray.service.TaskService;

@RestController
@RequestMapping(value="/pmo/task")
public class TaskController {

	@Autowired
	TaskService taskService;
	
	@GetMapping("/getAllTasks")
	public ValidResult getAllTask() {
		return taskService.getAllTask();
	}
	
	@PostMapping("/createTask")
	public ValidResult createTask(@RequestBody Task task) {
		return taskService.createTask(task);
	}
	
	@PostMapping("/updateTask")
	public ValidResult updateTask(@RequestBody Task task) {
		return taskService.updateTask(task);
	}
}
