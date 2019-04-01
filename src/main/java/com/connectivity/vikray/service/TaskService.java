package com.connectivity.vikray.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.connectivity.vikray.constant.VikrayPmoMessageConstant;
import com.connectivity.vikray.entity.Task;
import com.connectivity.vikray.entity.TaskComment;
import com.connectivity.vikray.payload.ApiResponse;
import com.connectivity.vikray.pojo.ValidResult;
import com.connectivity.vikray.serviceImpl.TaskServiceImpl;

@Service("TaskService")
public class TaskService {

	@Autowired
	TaskServiceImpl taskServiceImpl;

	@Autowired
	ValidResult result;

	public ValidResult getAllTask() {
		result.setData(taskServiceImpl.getAllTask());
		result.setErrorCode((long) 101);
		result.setErrorMsg(VikrayPmoMessageConstant.KEY_101);
		return result;
	}

	public ResponseEntity<ApiResponse> createTask(Task task) {
		ResponseEntity<ApiResponse> response = taskServiceImpl.createTask(task);
		return response;
	}

	public ResponseEntity<ApiResponse> updateTask(Task task) {
		ResponseEntity<ApiResponse> response = taskServiceImpl.updateTask(task);
		return response;
	}

	public ResponseEntity<ApiResponse> addTaskComments(TaskComment comments) {
		ResponseEntity<ApiResponse> response = taskServiceImpl.addTaskComment(comments);
		return response;
	}

	public ResponseEntity<ApiResponse> updateTaskComments(TaskComment comments) {
		ResponseEntity<ApiResponse> response = taskServiceImpl.updateTaskComment(comments);
		return response;
	}

	public ResponseEntity<ApiResponse> getTaskById(Long id) {
		ResponseEntity<ApiResponse> response = taskServiceImpl.getTaskById(id);
		return response;
	}

	public ResponseEntity<ApiResponse> getTaskBycreatorUser() {
		ResponseEntity<ApiResponse> response = taskServiceImpl.getTaskByCreatorUser();
		return response;
	}

	public ResponseEntity<ApiResponse> getTaskByGuId(String guid) {
		ResponseEntity<ApiResponse> response = taskServiceImpl.getTaskByGuid(guid);
		return response;
	}

}
