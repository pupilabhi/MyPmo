package com.connectivity.vikray.serviceImpl;

import java.net.URI;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resources;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.connectivity.vikray.constant.VikrayPmoConstant;
import com.connectivity.vikray.controller.ProjectController;
import com.connectivity.vikray.entity.Documents;
import com.connectivity.vikray.entity.Phase;
import com.connectivity.vikray.entity.Project;
import com.connectivity.vikray.entity.ProjectFollower;
import com.connectivity.vikray.entity.UserDetails;
import com.connectivity.vikray.payload.ApiResponse;
import com.connectivity.vikray.repository.DocumentRepository;
import com.connectivity.vikray.repository.PhaseRepository;
import com.connectivity.vikray.repository.ProjectFollwerRepository;
import com.connectivity.vikray.repository.ProjectRepository;
import com.connectivity.vikray.repository.StatusRepository;
import com.connectivity.vikray.repository.UserDetailsRepository;
import com.connectivity.vikray.resource.ProjectResource;
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
	StatusRepository statusRepository;

	/**
	 * @param Project
	 * @return Project Object on success Persisting project to data base
	 **/
	public ResponseEntity<ApiResponse> createProject(Project projectFrmClient) {
		Project toDb = new Project();
		toDb.setProjectName(projectFrmClient.getProjectName());
		toDb.setProjectDescription(projectFrmClient.getProjectDescription());
		if (projectFrmClient.getDueDate() != null)
			toDb.setDueDate(projectFrmClient.getDueDate());

		toDb.setAccountAddress(projectFrmClient.getAccountAddress());
		toDb.setSalesOrder(projectFrmClient.getSalesOrder());
		toDb.setProjectStatus(statusRepository.getOne(VikrayPmoConstant.PROJ_NEW));
		if (projectFrmClient.getOwner() == null) {
			return new ResponseEntity<ApiResponse>(new ApiResponse(false, "Project Owner Required!", null),
					HttpStatus.BAD_REQUEST);
		} else {
			toDb.setOwner(userDetailsRepository.getOne(projectFrmClient.getOwner().getId()));
		}
		toDb.setCustomerName(projectFrmClient.getCustomerName());
		toDb.setGuid(UUID.randomUUID().toString());
		if (projectFrmClient.getProjectFollowers().isEmpty()) {
			return new ResponseEntity<ApiResponse>(new ApiResponse(false, "Project Followers Required!", null),
					HttpStatus.BAD_REQUEST);
		}
		if (projectFrmClient.getPhases().isEmpty()) {
			return new ResponseEntity<ApiResponse>(new ApiResponse(false, "Project Phases Required!", null),
					HttpStatus.BAD_REQUEST);
		}

		Project newProject = projectRepository.save(toDb);
		if(newProject == null) {
			return new ResponseEntity<ApiResponse>(new ApiResponse(false, "Project Creation Failed", null),
					HttpStatus.EXPECTATION_FAILED);
		}
		Set<ProjectFollower> pf = createProjectFollower(projectFrmClient, toDb);
		Set<Phase> ph = createUpdatePhase(projectFrmClient, toDb);
		toDb.setProjectFollowers(pf);
		toDb.setPhases(ph);
		URI uri = MvcUriComponentsBuilder.fromController(ProjectController.class).path("/{id}")
				.buildAndExpand(toDb.getId()).toUri();
		return ResponseEntity.created(uri).body(new ApiResponse(true, "", new ProjectResource(toDb)));
	}

	// create Project Follower
	public Set<ProjectFollower> createProjectFollower(Project frmClient, Project project) {
		Set<ProjectFollower> followerFromClient = frmClient.getProjectFollowers();
		Set<ProjectFollower> newFollower = new HashSet<ProjectFollower>();
		Iterator<ProjectFollower> itr = followerFromClient.iterator();
		while (itr.hasNext()) {
			ProjectFollower followerToDb = new ProjectFollower();
			ProjectFollower followerfrmClient = (ProjectFollower) itr.next();
			followerToDb.setUserDetails(userDetailsRepository.getOne(followerfrmClient.getUserDetails().getId()));
			followerToDb.setProject(project);
			projectFollwerRepository.save(followerToDb);
			newFollower.add(followerToDb);
		}
		return newFollower;
	}

	// create Phases
	public Set<Phase> createUpdatePhase(Project frmClient, Project project) {
		Set<Phase> phasesFrmClient = frmClient.getPhases();
		Set<Phase> newPhases = new HashSet<Phase>();
		Iterator<Phase> itr = phasesFrmClient.iterator();
		while (itr.hasNext()) {
			Phase phaseFrmClient = (Phase) itr.next();
			if (phaseFrmClient.getId() == 0) {
				Phase newPhaseTodb = new Phase();
				newPhaseTodb.setPhaseName(phaseFrmClient.getPhaseName());
				newPhaseTodb.setProjectFk(project);
				newPhaseTodb.setGuid(UUID.randomUUID().toString());
				newPhaseTodb.setPhaseStatus(statusRepository.getOne(VikrayPmoConstant.PHASE_NEW));
				phaseRepository.save(newPhaseTodb);
				newPhases.add(newPhaseTodb);
			} else {
				phaseRepository.save(phaseFrmClient);
				newPhases.add(phaseFrmClient);
			}
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
	public ResponseEntity<ApiResponse> updateProject(Project projectFromClient) {
		
		if (!projectRepository.existsById(projectFromClient.getId())) {
			return new ResponseEntity<ApiResponse>(new ApiResponse(false, "Project Not Found!", null),
					HttpStatus.BAD_REQUEST);
		}
		Project projectFromDb = projectRepository.getOne(projectFromClient.getId());
		projectFromDb.setProjectName(projectFromClient.getProjectName());
		projectFromDb.setProjectDescription(projectFromClient.getProjectDescription());
		projectFromDb.setDueDate(projectFromClient.getDueDate());
		projectFromDb.setCustomerName(projectFromClient.getCustomerName());
		projectFromDb.setAccountAddress(projectFromClient.getAccountAddress());
		projectFromDb.setSalesOrder(projectFromClient.getSalesOrder());
		if (projectFromClient.getOwner() != null) {
			if (projectFromClient.getOwner().getId() != 0) {
				projectFromDb.setOwner(userDetailsRepository.getOne(projectFromClient.getOwner().getId()));
			}
		}

		// update ProjectFollower
		// Removing existing followers
		if (!projectFromDb.getProjectFollowers().isEmpty())
			projectFollwerRepository.deleteInBatch(projectFromDb.getProjectFollowers());

		// Adding Followers
		if (!projectFromClient.getProjectFollowers().isEmpty()) {
			Set<ProjectFollower> pf = createProjectFollower(projectFromClient, projectFromDb);
			projectFromDb.setProjectFollowers(pf);
		}
		
		//Removing existing phases
		if(!projectFromClient.getPhases().isEmpty())
			phaseRepository.deleteInBatch(projectFromDb.getPhases());
		
		//updating with new phases
		if(!projectFromClient.getPhases().isEmpty()) {
			Set<Phase> phases = createUpdatePhase(projectFromClient, projectFromDb);
			projectFromDb.setPhases(phases);// update Documents
		}
		
		Project updatedProject = projectRepository.save(projectFromDb);
		if (updatedProject == null) {
			return new ResponseEntity<ApiResponse>(new ApiResponse(false, "Oops!!, Project Update failed", null),
					HttpStatus.INTERNAL_SERVER_ERROR);
		} else {
			ProjectResource project = new ProjectResource(updatedProject); 
			 URI uri = ServletUriComponentsBuilder.fromCurrentRequest().build().toUri();
		    return ResponseEntity.created(uri).body(new ApiResponse(true, "", project));
		}
	}

	// getListOfProjects
	public ResponseEntity<Resources<?>> getAllProject() {
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
		List<ProjectResource> projectResource = null;
		projectResource = summary.stream().map(ProjectResource::new).collect(Collectors.toList());
		Resources<ProjectResource> resources = new Resources<>(projectResource);
		final String uriString = ServletUriComponentsBuilder.fromCurrentRequest().build().toUriString();
		resources.add(new Link(uriString, "self"));
		return ResponseEntity.ok(resources);

	}

	// getListOfAllUsersList
	public List<UserDetails> getAllUsersList() {
		return userDetailsRepository.findAll();
	}

	// get project by ID
	public ResponseEntity<ApiResponse> getProjectById(Long id) {
//		return  projectRepository
//				.findById(id)
//				.map(
//					p ->{
//						return ResponseEntity.ok(new ApiResponse(true, "",new ProjectResource(p)));
//					})
//				.orElseThrow(()->new ResourceNotFoundException(id));

		if (!projectRepository.existsById(id)) {
			return new ResponseEntity<ApiResponse>(new ApiResponse(false, "Project Not Found!", null),
					HttpStatus.ACCEPTED);
		}
		Project proFrmDb = projectRepository.getOne(id);
		URI location = ServletUriComponentsBuilder.fromCurrentContextPath().path("/project/getProjectById/{id}")
				.buildAndExpand(proFrmDb.getId()).toUri();

		return ResponseEntity.created(location).body(new ApiResponse(true, "", new ProjectResource(proFrmDb)));
	}

	public ResponseEntity<ApiResponse> validateProjectName(String name) {
		if (projectRepository.existsByProjectName(name)) {
			return new ResponseEntity<ApiResponse>(new ApiResponse(false, "Project Name already taken, Chose another", null),
					HttpStatus.ACCEPTED);
		}
		return new ResponseEntity<ApiResponse>(new ApiResponse(true, "", null),
				HttpStatus.ACCEPTED);
	}

}
