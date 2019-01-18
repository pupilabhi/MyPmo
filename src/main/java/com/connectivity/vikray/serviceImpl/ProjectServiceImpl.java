package com.connectivity.vikray.serviceImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.connectivity.vikray.entity.Project;
import com.connectivity.vikray.pojo.ValidResult;
import com.connectivity.vikray.repository.ProjectRepository;



@Repository
public class ProjectServiceImpl {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Autowired
	ProjectRepository projectRepository;
	
	@Autowired
	Project projectEntity;
	
	public Project createProject(Project project) {
		Project todb= new Project();
		entityManager.getTransaction().begin();
		entityManager.persist(project);
		entityManager.getTransaction().commit();
		return project;
	}

	@Transactional
	public List<Project> getAllProject() {
		return projectEntity.findAll();
	}

}
