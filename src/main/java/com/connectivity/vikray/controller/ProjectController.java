package com.connectivity.vikray.controller;

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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value= "/pmo/project")
@Api(value = "Project Related API's")
public class ProjectController {

	@Autowired
	ProjectService ProjectService;
	
	@ApiOperation(value = "Returns Project list based on status")
	@GetMapping("/getAllProjects")
	public ValidResult getAllProjects() {
		return ProjectService.getAllProject();
	}
	
	@ApiOperation(value = "Returns User list")
	@GetMapping("/getAllUsersList")
	public ValidResult getAllUserList() {
		return ProjectService.getAllUserList();
	}
	
	@ApiOperation(value = "Creates Project")
	@PostMapping("/creatProject")
	public ValidResult createProjects(@RequestBody Project project) {
		return ProjectService.createProject(project);
	}

	@ApiOperation(value = "Update particular project")
	@PostMapping("/updateProject")
	public ValidResult updateProjects(@RequestBody Project project) {
		return ProjectService.updateProject(project);
	}
	
	@GetMapping("/getProjectById/{id}")
	@ApiOperation(value = "Find Project by id",
    notes = "Also returns a link to retrieve all students with rel - all-students")
	public ValidResult getProjectById(@PathVariable("id") Long id) {
		return ProjectService.getProjectById(id);
		
	}
}
