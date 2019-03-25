package com.connectivity.vikray.resource;


import org.springframework.hateoas.ResourceSupport;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import com.connectivity.vikray.controller.ProjectController;
import com.connectivity.vikray.entity.Project;
import com.connectivity.vikray.summary.ProjectSummary;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProjectResource extends ResourceSupport{
	public Project project;
	public ProjectSummary projectSummary;

	public ProjectResource(Project project) {
	    this.project = project;
	    final long id = project.getId();
	    add(linkTo(ProjectController.class).withRel("projects"));
	    add(linkTo(methodOn(ProjectController.class).getAllProjects()).withRel("All"));
	    add(linkTo(methodOn(ProjectController.class).getProjectById(id)).withSelfRel());
	  }
	
	public ProjectResource(ProjectSummary summary) {
		this.projectSummary = summary;
		final long id = summary.getId();
		add(linkTo(methodOn(ProjectController.class).getAllProjects()).withRel("All"));
		add(linkTo(methodOn(ProjectController.class).getProjectById(id)).withSelfRel());
	}
	
}
