package com.connectivity.vikray.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.connectivity.vikray.entity.Task;
import com.connectivity.vikray.entity.TaskComment;
import com.connectivity.vikray.entity.TaskStatus;
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
	
	@GetMapping("/{guid}")
	public ResponseEntity<ApiResponse> getTaskByGuId(@PathVariable("guid") String guid) {
		return taskService.getTaskByGuId(guid);	
	}
	
	@PutMapping("/updateTask")
	public ResponseEntity<ApiResponse> updateTask(@RequestBody Task task) {
		return taskService.updateTask(task);
	}
	
	@PostMapping("/addTaskComments")
	public ResponseEntity<ApiResponse> addTaskComments(@RequestBody TaskComment comment) {
		return taskService.addTaskComments(comment);
	}
	
	@PostMapping("/updateTaskComments")
	public ResponseEntity<ApiResponse> updateTaskComments(@RequestBody TaskComment comment) {
		return taskService.updateTaskComments(comment);
	}
	
	@GetMapping("/getTaskByCreatorUser")
	public ResponseEntity<ApiResponse> getTaskByCreatorUser() {
		return taskService.getTaskBycreatorUser();
	}
	
	@PostMapping("/addStatus")
	public ResponseEntity<ApiResponse> addNewStatus(@RequestBody TaskStatus status){
		return taskService.createNewStatus(status);
	}
}
