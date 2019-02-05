package com.connectivity.vikray.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.connectivity.vikray.entity.Task;
import com.connectivity.vikray.repository.PhaseRepository;
import com.connectivity.vikray.repository.TaskRepository;

public class TaskServiceImpl {

	@Autowired
	TaskRepository taskRepository;
	
	public Task createPhase(Task task) {
		Task todb= new Task();
		taskRepository.save(task);
		return todb;
	}
	
	public List<Task> getAllTask(){
		return taskRepository.findAll();
	}
}
