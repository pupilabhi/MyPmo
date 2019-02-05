package com.connectivity.vikray.serviceImpl;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.connectivity.vikray.entity.Documents;
import com.connectivity.vikray.entity.Phase;
import com.connectivity.vikray.entity.PhaseFollower;
import com.connectivity.vikray.entity.Task;
import com.connectivity.vikray.pojo.ValidResult;
import com.connectivity.vikray.repository.DocumentRepository;
import com.connectivity.vikray.repository.PhaseFollowerRepository;
import com.connectivity.vikray.repository.PhaseRepository;
import com.connectivity.vikray.repository.ProjectRepository;
import com.connectivity.vikray.repository.TaskRepository;
import com.connectivity.vikray.repository.UserDetailsRepository;
import com.connectivity.vikray.service.PhaseService;

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
	public Phase createPhase(Phase phaseFrmClent) {
		Phase todb = new Phase();
		todb.setPhaseName(phaseFrmClent.getPhaseName());
		todb.setDueDate(phaseFrmClent.getDueDate());
		if (phaseFrmClent.getProjectFk() != null) {
			todb.setProjectFk(projectRepository.getOne(phaseFrmClent.getProjectFk().getId()));
		}
		todb.setAccountAddress(phaseFrmClent.getAccountAddress());
		phaseRepository.save(todb);

		Set<Documents> docs = createDocuments(phaseFrmClent, todb);
		Set<PhaseFollower> pf = createPhaseFollower(phaseFrmClent, todb);
		Set<Task> tk = createTask(phaseFrmClent, todb);
		todb.setDocuments(docs);
		todb.setPhaseFollowers(pf);
		todb.setTasks(tk);
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
			docsTodb.setPhaseFk(docsTodb.getPhaseFk());
			documentRepository.save(docsTodb);
			documents.add(docsTodb);
		}
		return documents;

	}

	// Create PhaseFollower
	public Set<PhaseFollower> createPhaseFollower(Phase phaseFrmClent, Phase phase) {
		Set<PhaseFollower> phasefrmClent = phaseFrmClent.getPhaseFollowers();
		Set<PhaseFollower> newPhases = new HashSet<PhaseFollower>();
		Iterator<PhaseFollower> itr = phasefrmClent.iterator();
		while (itr.hasNext()) {
			PhaseFollower ptodb = new PhaseFollower();
			ptodb = itr.next();
			ptodb.setUserDetailsFk(userDetailsRepository.getOne(ptodb.getUserDetailsFk().getId()));
			ptodb.setPhaseFk(phase);
			phaseFollowerRepository.save(ptodb);
			newPhases.add(ptodb);
		}
		return newPhases;

	}

	// Task Set
	public Set<Task> createTask(Phase phaseFrmClent, Phase phase) {
		Set<Task> taskfrmClient = phaseFrmClent.getTasks();
		Set<Task> newTask = new HashSet<Task>();
		Iterator<Task> itr = taskfrmClient.iterator();
		while (itr.hasNext()) {
			Task ttodb = new Task();
			ttodb = itr.next();
			ttodb.setPhaseFk(phase);
			taskRepository.save(ttodb);
			newTask.add(ttodb);
		}
		return newTask;

	}

	// Update Phases
	public Object updatePhase(Phase phasefrmclient) {
		Phase phasefrmdb = phaseRepository.getOne(phasefrmclient.getId());
		if (phasefrmdb == null) {
			return null;
		}
		phasefrmdb.setPhaseName(phasefrmclient.getPhaseName());
		phasefrmdb.setDueDate(phasefrmclient.getDueDate());

		if (phasefrmclient.getProjectFk() != null) {
			if (phasefrmclient.getProjectFk().getId() == 0) {
				phasefrmclient.setProjectFk(phasefrmclient.getProjectFk());
			} else {
				Phase phase = phaseRepository.getOne(phasefrmclient.getProjectFk().getId());
				phase.setProjectFk(phasefrmclient.getProjectFk());
			}
		}

		phasefrmdb.setAccountAddress(phasefrmclient.getAccountAddress());

		// update Documents
		for (Documents documents : phasefrmclient.getDocuments()) {
			if (documents.getId() == 0) {
				documents.setPhaseFk(phasefrmdb);
				documentRepository.save(documents);
			} else {
				Documents dtobd = documentRepository.getOne(documents.getId());
			}
		}

		// update Phase Followers
		for (PhaseFollower phaseFollower : phasefrmclient.getPhaseFollowers()) {
			if (phaseFollower.getId() == 0) {
				phaseFollower.setPhaseFk(phasefrmdb);
				phaseFollowerRepository.save(phaseFollower);
			} else {
				PhaseFollower ptodb = phaseFollowerRepository.getOne(phaseFollower.getId());
			}
		}

		// Update Task
		for (Task task : phasefrmclient.getTasks()) {
			if (task.getId() == 0) {
				task.setPhaseFk(phasefrmdb);
				taskRepository.save(task);
			} else {
				Task ttodb = taskRepository.getOne(task.getId());
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

}
