package com.connectivity.vikray.serviceImpl;

import java.net.URI;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resources;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.connectivity.vikray.controller.PhaseController;
import com.connectivity.vikray.entity.Documents;
import com.connectivity.vikray.entity.Phase;
import com.connectivity.vikray.entity.TeamMember;
import com.connectivity.vikray.payload.ApiResponse;
import com.connectivity.vikray.repository.DocumentRepository;
import com.connectivity.vikray.repository.PhaseRepository;
import com.connectivity.vikray.repository.ProjectRepository;
import com.connectivity.vikray.repository.TeamMemberRepository;
import com.connectivity.vikray.repository.UserDetailsRepository;
import com.connectivity.vikray.resource.PhaseResource;

@Repository
public class PhaseServiceImpl {

	@Autowired
	PhaseRepository phaseRepository;

	@Autowired
	ProjectRepository projectRepository;

	@Autowired
	DocumentRepository documentRepository;

	@Autowired
	UserDetailsRepository userDetailsRepository;

	@Autowired
	TeamMemberRepository teamMeberRepository;

	

	// Create Phases
	@Transactional
	public ResponseEntity<ApiResponse> createPhase(Phase phaseFrmClent) {
		Phase toDb = new Phase();
		toDb.setPhaseName(phaseFrmClent.getPhaseName());
		toDb.setDueDate(phaseFrmClent.getDueDate());
		toDb.setGuid(UUID.randomUUID().toString());
		if (phaseFrmClent.getProjectFk() != null) {
			toDb.setProjectFk(projectRepository.getOne(phaseFrmClent.getProjectFk().getId()));
		}
		toDb.setAccountAddress(phaseFrmClent.getAccountAddress());
		
		Set<Documents> docs = createDocuments(phaseFrmClent, toDb);
		toDb.setDocuments(docs);
		Phase newPhase = phaseRepository.save(toDb);
		if(newPhase == null) {
			return new ResponseEntity<ApiResponse>(new ApiResponse(false, "Success", null),
					HttpStatus.EXPECTATION_FAILED);
		}
		URI uri = MvcUriComponentsBuilder.fromController(PhaseController.class).path("/{id}")
				.buildAndExpand(toDb.getId()).toUri();
		return ResponseEntity.created(uri).body(new ApiResponse(true, "", new PhaseResource(toDb)));
	}

	// create Documents
	public Set<Documents> createDocuments(Phase phaseFrmClent, Phase phase) {
		Set<Documents> docsfrmClient = phaseFrmClent.getDocuments();
		Set<Documents> documents = new HashSet<Documents>();
		Iterator<Documents> itr = docsfrmClient.iterator();
		while (itr.hasNext()) {
			Documents docsTodb = new Documents();
			docsTodb = itr.next();
			docsTodb.setPath(docsTodb.getPath());
			docsTodb.setPhaseFk(phase);
			documentRepository.save(docsTodb);
			documents.add(docsTodb);
		}
		return documents;
	}
	
	// Create PhaseFollower
	public Set<TeamMember> createTeamMember(Phase phaseFrmClent, Phase phase) {
		Set<TeamMember> phasefrmClent = phaseFrmClent.getTeamMembers();
		Set<TeamMember> newPhases = new HashSet<TeamMember>();
		Iterator<TeamMember> itr = phasefrmClent.iterator();
		while (itr.hasNext()) {
			TeamMember teamToDb = new TeamMember();
			teamToDb = (TeamMember) itr.next();
			teamToDb.setUserDetailsFk(userDetailsRepository.getOne(teamToDb.getUserDetailsFk().getId()));
			teamToDb.setPhaseFk(phase);
			teamMeberRepository.save(teamToDb);
			newPhases.add(teamToDb);
		}
		return newPhases;
	}

	
	// Update Phases
	public ResponseEntity<ApiResponse> updatePhase(Phase phasefrmclient) {
		
		if (!phaseRepository.existsById(phasefrmclient.getId())) {
			return new ResponseEntity<ApiResponse>(new ApiResponse(false, "Phase Not Found", null),
					HttpStatus.BAD_REQUEST);
		}
		
		Phase phasefrmdb = phaseRepository.getOne(phasefrmclient.getId());
		phasefrmdb.setPhaseName(phasefrmclient.getPhaseName());
		if(phasefrmclient.getDueDate() != null)
			phasefrmdb.setDueDate(phasefrmclient.getDueDate());
		
		phasefrmdb.setAccountAddress(phasefrmclient.getAccountAddress());
		if(phasefrmclient.getPhaseDescription() != null)
			phasefrmdb.setPhaseDescription(phasefrmclient.getPhaseDescription());
		
		// update Documents
		for (Documents doc : phasefrmclient.getDocuments()) {
			if (doc.getId() == 0) {
				Documents newDoc =  new Documents();
				newDoc.setPath(doc.getPath());
				newDoc.setDocType(doc.getDocType());
				newDoc.setPhaseFk(phasefrmdb);
				documentRepository.save(newDoc);
			} else {
				Documents docFrmDb = documentRepository.getOne(doc.getId());
				docFrmDb.setPath(doc.getPath());
				docFrmDb.setDocType(doc.getDocType());
				documentRepository.save(docFrmDb);;
			}
		}


		Phase updatePhase = phaseRepository.save(phasefrmdb);
		if (updatePhase == null) {
			return new ResponseEntity<ApiResponse>(new ApiResponse(false, "Phase not updated", null),
					HttpStatus.EXPECTATION_FAILED);
		} else {
			URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().build().toUri();
			return ResponseEntity.created(uri).body(new ApiResponse(true, "", new PhaseResource(updatePhase)));
		}
	}

	public ResponseEntity<ApiResponse> getPhasesByProjectId(Long projectId) {
		List<Phase> phases = phaseRepository.findByProjectFk(projectRepository.getOne(projectId));
		if(phases.isEmpty()) {
			return new ResponseEntity<ApiResponse>(new ApiResponse(false, 
					"No phases found for project with id : "+projectId, null),
					HttpStatus.ACCEPTED);
		}
		List<PhaseResource> phaseResource = null;
		phaseResource = phases.stream().map(PhaseResource::new).collect(Collectors.toList());
		Resources<PhaseResource> resources = new Resources<>(phaseResource);
		 URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().build("/phases/{}");
		resources.add(new Link(uri.toString(),"Self"));
		return ResponseEntity.created(uri).body(new ApiResponse(true, "", resources));
	}

	public ResponseEntity<ApiResponse> getPhaseById(Long id) {
		if (!phaseRepository.existsById(id)){
			return new ResponseEntity<ApiResponse>(new ApiResponse(false,"Phase With ID : "+id+" Not found",null),
					HttpStatus.BAD_REQUEST);
		}
		Phase phase = phaseRepository.getOne(id);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().buildAndExpand("/{id}").toUri();
		return ResponseEntity.created(uri).body(new ApiResponse(true, "", new PhaseResource(phase)));
	}

	public ResponseEntity<ApiResponse> getPhaseByGuId(String guid) {
		if (!phaseRepository.existsByGuid(guid)){
			return new ResponseEntity<ApiResponse>(new ApiResponse(false,"Phase With ID : "+guid+" Not found",null),
					HttpStatus.BAD_REQUEST);
		}
		Phase phase = phaseRepository.findByGuid(guid);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().buildAndExpand("/{id}").toUri();
		return ResponseEntity.created(uri).body(new ApiResponse(true, "", new PhaseResource(phase)));
	}

	public ResponseEntity<ApiResponse> createTeamMember(TeamMember member) {
		TeamMember tm = new TeamMember();
		tm.setPhaseFk(phaseRepository.getOne(member.getPhaseFk().getId()));
		tm.setUserDetailsFk(userDetailsRepository.getOne(member.getUserDetailsFk().getId()));
		teamMeberRepository.save(tm);
		URI uri = MvcUriComponentsBuilder.fromController(PhaseController.class).path("/{id}").buildAndExpand(tm.getPhaseFk().getId()).toUri();
		return ResponseEntity.created(uri).body(new ApiResponse(true, "", tm));
	}

	public ResponseEntity<ApiResponse> removePhase(Long id) {
		if(!phaseRepository.existsById(id)) {
			return new ResponseEntity<ApiResponse>(new ApiResponse(false, "Phase with id : "+id+" Not Found", null),
					HttpStatus.BAD_REQUEST);
		}
		Phase _phaseFrmDb = phaseRepository.getOne(id);
		if(!_phaseFrmDb.getTasks().isEmpty()) {
			return new ResponseEntity<ApiResponse>(new ApiResponse(false, "Phase with id : "+id+" Cannot be deleted Since Task has been created against this Phase", null),
					HttpStatus.ACCEPTED);
		}
		phaseRepository.delete(_phaseFrmDb);
		return ResponseEntity.accepted().body(new ApiResponse(true, "Phase deleted successfully", null));
	}

	public ResponseEntity<ApiResponse> removeMember(Long id) {
		if(!teamMeberRepository.existsById(id)) {
			return new ResponseEntity<ApiResponse>(new ApiResponse(false, "Team Member with id : "+id+" Not Found", null),
					HttpStatus.BAD_REQUEST);
		}
		teamMeberRepository.delete(teamMeberRepository.getOne(id));
		return ResponseEntity.accepted().body(new ApiResponse(true, "Team Member deleted successfully", null));
	}

}
