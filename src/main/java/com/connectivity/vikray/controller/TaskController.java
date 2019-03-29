package com.connectivity.vikray.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.connectivity.vikray.entity.Task;
import com.connectivity.vikray.entity.TaskComment;
import com.connectivity.vikray.payload.ApiResponse;
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
	public ResponseEntity<ApiResponse> createTask(@RequestBody Task task) {
		return taskService.createTask(task);
	}
	
	@GetMapping("/getTaskById/{id}")
	public ValidResult getTaskById(@PathVariable("id") Long id) {
		return taskService.getTaskById(id);	
	}
	
	@PostMapping("/updateTask")
	public ValidResult updateTask(@RequestBody Task task) {
		return taskService.updateTask(task);
	}
	
	@PostMapping("/addTaskComments")
	public ValidResult addTaskComments(@RequestBody TaskComment comment) {
		return taskService.addTaskComments(comment);
	}
	
	@PostMapping("/updateTaskComments")
	public ValidResult updateTaskComments(@RequestBody TaskComment comment) {
		return taskService.updateTaskComments(comment);
	}
	
	@GetMapping("/getTaskByCreatorUser")
	public ValidResult getTaskByCreatorUser() {
		return taskService.getTaskBycreatorUser();
	}
}
