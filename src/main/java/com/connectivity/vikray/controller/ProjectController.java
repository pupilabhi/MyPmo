package com.connectivity.vikray.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resources;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.connectivity.vikray.entity.Project;
import com.connectivity.vikray.payload.ApiResponse;
import com.connectivity.vikray.pojo.ValidResult;
import com.connectivity.vikray.service.ProjectService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping(value= "/pmo/project", produces = "application/hal+json")
@Api(value = "Project Services", description = "")
public class ProjectController {

	@Autowired
	ProjectService projectService;
	
	@ApiOperation(value = "Returns Project list based on status")
	@GetMapping("/getAllProjects")
	public ResponseEntity<Resources<?>> getAllProjects() {
		return projectService.getAllProject();
	}
	
	@ApiOperation(value = "Returns User list")
	@GetMapping("/getAllUsersList")
	public ValidResult getAllUserList() {
		return projectService.getAllUserList();
	}
	
	@ApiOperation(value = "Creates Project")
	@PostMapping("/creatProject")
	public ResponseEntity<ApiResponse> createProjects(
			@ApiParam(value = "Project object store in database table", required = true) @RequestBody Project project) {
		return projectService.createProject(project);
	}

	@ApiOperation(value = "Update particular project")
	@PutMapping("/updateProject")
	public ResponseEntity<ApiResponse> updateProjects(@RequestBody Project project) {
		return projectService.updateProject(project);
	}
	
	@GetMapping("/getProjectById/{id}")
	@ApiOperation(value = "Find Project by id")
	public ResponseEntity<ApiResponse> getProjectById(@PathVariable("id") Long id) {
		return projectService.getProjectById(id);
	}
	
	@GetMapping("/validate/{name}")
	@ApiOperation(value = "Validate for duplicate project name")
	public ResponseEntity<ApiResponse> checkDuplicate(@PathVariable String name){
		return projectService.validateDuplicateProject(name);
	}
}
