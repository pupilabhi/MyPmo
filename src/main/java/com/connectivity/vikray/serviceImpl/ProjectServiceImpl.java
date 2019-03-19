package com.connectivity.vikray.serviceImpl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.connectivity.vikray.constant.VikrayPmoConstant;
import com.connectivity.vikray.entity.Documents;
import com.connectivity.vikray.entity.Phase;
import com.connectivity.vikray.entity.Project;
import com.connectivity.vikray.entity.ProjectFollower;
import com.connectivity.vikray.entity.UserDetails;
import com.connectivity.vikray.repository.DocumentRepository;
import com.connectivity.vikray.repository.PhaseRepository;
import com.connectivity.vikray.repository.ProjectFollwerRepository;
import com.connectivity.vikray.repository.ProjectRepository;
import com.connectivity.vikray.repository.StatusRepository;
import com.connectivity.vikray.repository.UserDetailsRepository;
import com.connectivity.vikray.summary.ProjectSummary;

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

	@Autowired
	StatusRepository statusRepo;

	// create Project

	public Project createProject(Project projectFrmClent) {
		Project toDb = new Project();
		toDb.setProjectName(projectFrmClent.getProjectName());
		toDb.setProjectDescription(projectFrmClent.getProjectDescription());
		if (projectFrmClent.getDueDate() != null)
			toDb.setDueDate(projectFrmClent.getDueDate());

		toDb.setAccountAddress(projectFrmClent.getAccountAddress());
		toDb.setSalesOrder(projectFrmClent.getSalesOrder());
		toDb.setProjectStatus(statusRepo.getOne(VikrayPmoConstant.PROJ_NEW));
		if (projectFrmClent.getOwner() != null) {
			toDb.setOwner(userDetailsRepository.getOne(projectFrmClent.getOwner().getId()));
		}
		toDb.setCustomerName(projectFrmClent.getCustomerName());
		toDb.setGuid(UUID.randomUUID().toString());
		projectRepository.save(toDb);
		Set<ProjectFollower> pf = createProjectFollower(projectFrmClent, toDb);
		Set<Phase> ph = createPhase(projectFrmClent, toDb);
		Set<Documents> doc = createDocuments(projectFrmClent, toDb);
		toDb.setProjectFollowers(pf);
		toDb.setPhases(ph);
		toDb.setDocuments(doc);
		return toDb;
	}

	// create Project Follower
	public Set<ProjectFollower> createProjectFollower(Project frmClient, Project project) {
		Set<ProjectFollower> followerFromClient = frmClient.getProjectFollowers();
		Set<ProjectFollower> newFollower = new HashSet<ProjectFollower>();
		Iterator<ProjectFollower> itr = followerFromClient.iterator();
		while (itr.hasNext()) {
			ProjectFollower followerToDb = new ProjectFollower();
			ProjectFollower	followerfrmClient = (ProjectFollower) itr.next();
			followerToDb.setUserDetails(userDetailsRepository.getOne(followerfrmClient.getUserDetails().getId()));
			followerToDb.setProject(project);
			projectFollwerRepository.save(followerToDb);
			newFollower.add(followerToDb);
		}
		return newFollower;
	}

	// create Phases
	public Set<Phase> createPhase(Project frmClient, Project project) {
		Set<Phase> phaseFrmClient = frmClient.getPhases();
		Set<Phase> newPhases = new HashSet<Phase>();
		Iterator<Phase> itr = phaseFrmClient.iterator();
		while (itr.hasNext()) {
			Phase phaseTodb = new Phase();
			phaseTodb = (Phase) itr.next();
			phaseTodb.setProjectFk(project);
			phaseTodb.setPhaseStatus(statusRepo.getOne(VikrayPmoConstant.PHASE_NEW));
			phaseRepository.save(phaseTodb);
			newPhases.add(phaseTodb);
		}
		return newPhases;
	}

	// create Documents
	public Set<Documents> createDocuments(Project frmClient, Project project) {
		Set<Documents> documentsFrmClient = frmClient.getDocuments();
		Set<Documents> newDocuments = new HashSet<Documents>();
		Iterator<Documents> itr = documentsFrmClient.iterator();
		while (itr.hasNext()) {
			Documents docsTodb = new Documents();
			docsTodb = (Documents) itr.next();
			docsTodb.setPath(docsTodb.getPath());
			docsTodb.setProjectFk(project);
			docsTodb.setDocType(docsTodb.getDocType());
			documentRepository.save(docsTodb);
			newDocuments.add(docsTodb);
		}
		return newDocuments;
	}

	// update Project
	public Project updateProject(Project projectFromClient) {
		Project projectfromdb = projectRepository.getOne(projectFromClient.getId());
		if (projectfromdb == null) {
			return null;
		}
		projectfromdb.setProjectName(projectFromClient.getProjectName());
		projectfromdb.setProjectDescription(projectFromClient.getProjectDescription());
		projectfromdb.setDueDate(projectFromClient.getDueDate());
		projectfromdb.setCustomerName(projectFromClient.getCustomerName());
		projectfromdb.setAccountAddress(projectFromClient.getAccountAddress());
		projectfromdb.setSalesOrder(projectFromClient.getSalesOrder());
		projectfromdb.setOwner(userDetailsRepository.getOne(projectFromClient.getOwner().getId()));
		//update ProjectFollower
		//Removing existing followers
		if(!projectfromdb.getProjectFollowers().isEmpty())
			projectFollwerRepository.deleteAll(projectfromdb.getProjectFollowers());
		
		//Adding Followers
		if(!projectFromClient.getProjectFollowers().isEmpty()) {
			Set<ProjectFollower> pf = createProjectFollower(projectFromClient, projectfromdb);
			projectfromdb.setProjectFollowers(pf);
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
	public List<ProjectSummary> getAllProject() {
		List<Project> projects = null;
		projects = projectRepository.findAll();
		List<ProjectSummary> summary = null;
		summary = new ArrayList<ProjectSummary>();
		Iterator<Project> itr = projects.iterator();
		while (itr.hasNext()) {
			Project project = itr.next();
			ProjectSummary ps = new ProjectSummary(project);

			summary.add(ps);
		}
		return summary;

	}

	// getListOfAllUsersList
	public List<UserDetails> getAllUsersList() {
		return userDetailsRepository.findAll();
	}

	// get project by ID
	public Object getProjectById(Long id) {
		Project proFrmDb = projectRepository.getOne(id);
		return proFrmDb;
	}

}
