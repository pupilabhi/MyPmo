package com.connectivity.vikray.controller;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.connectivity.vikray.entity.Project;
import com.connectivity.vikray.pojo.ValidResult;
import com.connectivity.vikray.service.ProjectService;

@RestController
@RequestMapping(value= "/pmo/project")
public class ProjectController {

	@Autowired
	ProjectService ProjectService;
	
	@GetMapping("/getAllProjects")
	public ValidResult getAllProjects() {
		return ProjectService.getAllProject();
	}
	
	@GetMapping("/getAllUsersList")
	public ValidResult getAllUserList() {
		return ProjectService.getAllUserList();
	}
	
	@PostMapping("/creatProject")
	public ValidResult createProjects(@RequestBody Project project) {
		return ProjectService.createProject(project);
	}

	@PostMapping("/updateProject")
	public ValidResult updateProjects(@RequestBody Project project) {
		return ProjectService.updateProject(project);
	}
	
	@GetMapping("/getProjectById/{id}")
	public ValidResult getProjectById(@PathVariable("id") Long id) {
		return ProjectService.getProjectById(id);
		
	}
}
