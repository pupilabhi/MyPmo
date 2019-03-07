package com.connectivity.vikray.serviceImpl;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.connectivity.vikray.entity.Documents;
import com.connectivity.vikray.entity.Phase;
import com.connectivity.vikray.entity.PhaseFollower;
import com.connectivity.vikray.entity.Project;
import com.connectivity.vikray.entity.Task;
import com.connectivity.vikray.repository.DocumentRepository;
import com.connectivity.vikray.repository.PhaseFollowerRepository;
import com.connectivity.vikray.repository.PhaseRepository;
import com.connectivity.vikray.repository.ProjectRepository;
import com.connectivity.vikray.repository.TaskRepository;
import com.connectivity.vikray.repository.UserDetailsRepository;

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
	PhaseFollowerRepository phaseFollowerRepository;

	@Autowired
	TaskRepository taskRepository;

	// Create Phases
	@Transactional
	public Phase createPhase(Phase phaseFrmClent) {
		Phase todb = new Phase();
		todb.setPhaseName(phaseFrmClent.getPhaseName());
		todb.setDueDate(phaseFrmClent.getDueDate());
		todb.setGuid(UUID.randomUUID().toString());
		if (phaseFrmClent.getProjectFk() != null) {
			todb.setProjectFk(projectRepository.getOne(phaseFrmClent.getProjectFk().getId()));
		}
		todb.setAccountAddress(phaseFrmClent.getAccountAddress());
		
		Set<Documents> docs = createDocuments(phaseFrmClent, todb);
		todb.setDocuments(docs);
		
		phaseRepository.save(todb);
		return todb;
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
	

	/*public Set<Task> createTask(Phase phasefrmClent, Phase phase){
		Set<Task> taskfrmClient= phasefrmClent.getTasks();
		Set<Task> newTask= new HashSet<Task>();
		Iterator<Task> itr= taskfrmClient.iterator();
		while (itr.hasNext()) {
			Task tasktodb= new Task();
			tasktodb= (Task)itr.next();
			tasktodb.setPhaseFk(phase);
			taskRepository.save(tasktodb);
			newTask.add(tasktodb);
		}
		return newTask;
		
	}
	// Create PhaseFollower
	public Set<PhaseFollower> createPhaseFollower(Phase phaseFrmClent, Phase phase) {
		Set<PhaseFollower> phasefrmClent = phaseFrmClent.getPhaseFollowers();
		Set<PhaseFollower> newPhases = new HashSet<PhaseFollower>();
		Iterator<PhaseFollower> itr = phasefrmClent.iterator();
		while (itr.hasNext()) {
			PhaseFollower ptodb = new PhaseFollower();
			ptodb = (PhaseFollower) itr.next();
			ptodb.setUserDetailsFk(userDetailsRepository.getOne(ptodb.getUserDetailsFk().getId()));
			ptodb.setPhaseFk(phase);
			phaseFollowerRepository.save(ptodb);
			newPhases.add(ptodb);
		}
		return newPhases;
	}
*/
	
	// Update Phases
	public Phase updatePhase(Phase phasefrmclient) {
		Phase phasefrmdb = phaseRepository.getOne(phasefrmclient.getId());
		if (phasefrmdb == null) {
			return null;
		}
		phasefrmdb.setPhaseName(phasefrmclient.getPhaseName());
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

		// update Phase Followers
		for (PhaseFollower phaseFollower : phasefrmclient.getPhaseFollowers()) {
			if (phaseFollower.getId() == 0) {
				PhaseFollower newFollower = new PhaseFollower();
				newFollower.setPhaseFk(phasefrmdb);
				newFollower.setUserDetailsFk(userDetailsRepository.getOne(phaseFollower.getUserDetailsFk().getId()));
				phaseFollowerRepository.save(phaseFollower);
			} else {
				PhaseFollower follFrmDb = phaseFollowerRepository.getOne(phaseFollower.getId());
				follFrmDb.setUserDetailsFk(userDetailsRepository.getOne(phaseFollower.getUserDetailsFk().getId()));
			}
		}

		Phase updatePhase = phaseRepository.save(phasefrmdb);
		if (updatePhase != null) {
			return updatePhase;
		} else {
			return null;
		}
	}

	// getList of All Phases
	public List<Phase> getAllPhase() {
		return phaseRepository.findAll();
	}

	public Object getPhasesByProjectId(Long projectId) {
		return phaseRepository.findByProjectFk(projectRepository.getOne(projectId));
	}

}
