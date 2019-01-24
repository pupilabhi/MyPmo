/*package com.connectivity.vikray.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.connectivity.vikray.entity.Project;
import com.connectivity.vikray.pojo.ValidResult;
import com.connectivity.vikray.service.ProjectService;

@RestController
@RequestMapping(value="/pmo")
public class ProjectController {

	@Autowired
	ProjectService ProjectService;
	
	@GetMapping("/getAllProjects")
	public ValidResult getAllProjects() {
		return ProjectService.getAllProject();
	}
	
	@PostMapping("/creatProject")
	public ValidResult createProjects(@RequestBody Project project) {
		return ProjectService.createProject(project);
	}
	
}
*/