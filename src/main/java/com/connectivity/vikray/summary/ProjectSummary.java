package com.connectivity.vikray.summary;

import java.util.Date;

import com.connectivity.vikray.entity.Project;
import com.connectivity.vikray.entity.UserDetails;

public class ProjectSummary {
	private long id;
	private String projectName;
	private String projectDescription;
	private Date dueDate;
	private String owner;

	public ProjectSummary(Project project) {
		this.setId(project.getId());
		this.setProjectName(project.getProjectName());
		this.setProjectDescription(project.getProjectDescription());
		this.setDueDate(project.getDueDate());
		if (project.getOwner().getLastName() == null)
			this.setOwner(project.getOwner().getFirstName());
			this.setOwner(project.getOwner().getFirstName() + " " + project.getOwner().getLastName());

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getProjectDescription() {
		return projectDescription;
	}

	public void setProjectDescription(String projectDescription) {
		this.projectDescription = projectDescription;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

}
