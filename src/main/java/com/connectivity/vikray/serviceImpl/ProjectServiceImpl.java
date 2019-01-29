package com.connectivity.vikray.serviceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.connectivity.vikray.entity.Documents;
import com.connectivity.vikray.entity.Phase;
import com.connectivity.vikray.entity.Project;
import com.connectivity.vikray.entity.ProjectFollower;
import com.connectivity.vikray.entity.UserDetails;
import com.connectivity.vikray.pojo.ValidResult;
import com.connectivity.vikray.repository.DocumentRepository;
import com.connectivity.vikray.repository.PhaseRepository;
import com.connectivity.vikray.repository.ProjectFollwerRepository;
import com.connectivity.vikray.repository.ProjectRepository;
import com.connectivity.vikray.repository.UserDetailsRepository;

@Repository
public class ProjectServiceImpl {

	@Autowired
	ProjectRepository projectRepository;

	@Autowired
	UserDetailsRepository userDetailsRepository;

	@Autowired
	ProjectFollwerRepository projectFollwerRepository;

	@Autowired
	PhaseRepository phaseRepository;

	@Autowired
	DocumentRepository documentRepository;

	// create Project Follower
	public Set<ProjectFollower> createProjectFollower(Project project) {
		Set<ProjectFollower> followerFromClient = project.getProjectFollowers();
		Set<ProjectFollower> newFollower = new HashSet<ProjectFollower>();
		Iterator<ProjectFollower> itr = followerFromClient.iterator();
		while (itr.hasNext()) {
			ProjectFollower followerToDb = new ProjectFollower();
			followerToDb = (ProjectFollower) itr.next();
			followerToDb.setUserDetails(userDetailsRepository.getOne(followerToDb.getUserDetails().getId()));
			projectFollwerRepository.save(followerToDb);
			newFollower.add(followerToDb);
		}
		return newFollower;
	}

	// create Phases
	public Set<Phase> createPhase(Project project) {
		Set<Phase> phaseFrmClient = project.getPhases();
		Set<Phase> newPhases = new HashSet<Phase>();
		Iterator<Phase> itr = phaseFrmClient.iterator();
		while (itr.hasNext()) {
			Phase phaseTodb = new Phase();
			phaseTodb = (Phase) itr.next();
			phaseRepository.save(phaseTodb);
			newPhases.add(phaseTodb);
		}
		return newPhases;
	}

	// create Documents
	public Set<Documents> createDocuments(Project project) {
		Set<Documents> documentsFrmClient = project.getDocuments();
		Set<Documents> newDocuments = new HashSet<Documents>();
		Iterator<Documents> itr = documentsFrmClient.iterator();
		while (itr.hasNext()) {
			Documents docsTodb = new Documents();
			docsTodb = (Documents) itr.next();
			documentRepository.save(docsTodb);
			newDocuments.add(docsTodb);
		}
		return newDocuments;
	}

	// create Project
	public Project createProject(Project projectFrmClent) {
		Project toDb = new Project();
		toDb.setProjectName(projectFrmClent.getProjectName());
		toDb.setProjectDescription(projectFrmClent.getProjectDescription());
		if (projectFrmClent.getCreatedByFk() != null) {
			toDb.setCreatedByFk(userDetailsRepository.getOne(projectFrmClent.getCreatedByFk().getId()));
		}
		if (projectFrmClent.getUpdatedByFk() != null) {
			toDb.setUpdatedByFk(userDetailsRepository.getOne(projectFrmClent.getUpdatedByFk().getId()));
		}
		toDb.setDueDate(projectFrmClent.getDueDate());
		toDb.setAccountAddress(projectFrmClent.getAccountAddress());
		toDb.setSalesOrder(projectFrmClent.getSalesOrder());
		if (projectFrmClent.getOwner() != null) {
			toDb.setOwner(userDetailsRepository.getOne(projectFrmClent.getOwner().getId()));
		}
		toDb.setProjectFollowers(createProjectFollower(projectFrmClent));
		toDb.setPhases(createPhase(projectFrmClent));
		toDb.setDocuments(createDocuments(projectFrmClent));
		toDb.setCreateDate(projectFrmClent.getCreateDate());
		toDb.setModifyDate(projectFrmClent.getModifyDate());

		Project pr = projectRepository.save(toDb);
		return pr;

	}

	// update Project
	public Project updateProject(Project projectFromClient) {
		Project projectfromdb = projectRepository.getOne(projectFromClient.getId());
		if (projectfromdb == null) {
			return null;
		}
		projectfromdb.setProjectName(projectFromClient.getProjectName());
		projectfromdb.setProjectDescription(projectFromClient.getProjectDescription());
		if (projectFromClient.getOwner() != null) {
			if (projectFromClient.getOwner().getId() == 0) {
				projectfromdb.setCreatedByFk(projectFromClient.getCreatedByFk());
			} else {
				UserDetails details = userDetailsRepository.getOne(projectFromClient.getOwner().getId());
				details.setUserDetails(projectFromClient.getOwner());
			}
		}

		if (projectFromClient.getOwner() != null) {
			if (projectFromClient.getOwner().getId() == 0) {
				projectfromdb.setUpdatedByFk(projectFromClient.getUpdatedByFk());
			} else {
				UserDetails details = userDetailsRepository.getOne(projectFromClient.getOwner().getId());
				details.setUserDetails(projectFromClient.getOwner());
			}
		}
		projectfromdb.setDueDate(projectFromClient.getDueDate());
		projectfromdb.setCreateDate(projectFromClient.getCreateDate());
		projectfromdb.setModifyDate(projectFromClient.getModifyDate());
		projectfromdb.setAccountAddress(projectFromClient.getAccountAddress());
		projectfromdb.setSalesOrder(projectFromClient.getSalesOrder());

		if (projectFromClient.getOwner() != null) {
			if (projectFromClient.getOwner().getId() == 0) {
				projectFromClient.setOwner(projectFromClient.getOwner());
			} else {
				UserDetails details = userDetailsRepository.getOne(projectFromClient.getOwner().getId());
				details.setUserDetails(projectFromClient.getOwner());
			}
		}

		// update ProjectFollower
		for (ProjectFollower follower : projectFromClient.getProjectFollowers()) {
			if (follower.getId() == 0) {
				follower.setProject(projectfromdb);
				projectRepository.save(follower);
			} else {
				ProjectFollower projectsFrmDb = projectFollwerRepository.getOne(follower.getId());
				projectsFrmDb.setUserDetails(projectFromClient.getOwner());
			}
		}

		// update Phases
		for (Phase phases : projectFromClient.getPhases()) {
			if (phases.getId() == 0) {
				phases.setProjectFk(projectfromdb);
				projectRepository.save(phases);
			} else {
				Phase phaseFromDb = phaseRepository.getOne(phases.getId());
				// phaseFromDb.setProjectFk(projectFromClient.getProjectName());
			}
		}

		// update Documents
		for (Documents documents : projectFromClient.getDocuments()) {
			if (documents.getId() == 0) {
				documents.setProjectFk(projectfromdb);
				documentRepository.save(documents);
			} else {
				Documents docFrmDb = documentRepository.getOne(documents.getId());
				// docFrmDb.setDocu(projectFromClient.getDocuments());

			}
		}
		Project updatedProject = projectRepository.save(projectfromdb);
		if (updatedProject != null) {
			return updatedProject;
		} else {
			return null;
		}
	}

	// getListOfProjects
	public List<Project> getAllProject() {
		List<Project> list = new ArrayList<Project>();
		for (Project project : list) {
			Set<Phase> p = project.getPhases();
		}
		return projectRepository.findAll();
	}
}
