package com.connectivity.vikray.resource;

import org.springframework.hateoas.ResourceSupport;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import com.connectivity.vikray.controller.TaskController;
import com.connectivity.vikray.entity.Task;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaskResource extends ResourceSupport{

	public Task task;
	
	public TaskResource(Task task) {
		this.task = task;
		long id = task.getId();
		add(linkTo(TaskController.class).withSelfRel());
		add(linkTo(methodOn(TaskController.class).getTaskById(id)).withSelfRel());
		// TODO Auto-generated constructor stub
	}
	
}
