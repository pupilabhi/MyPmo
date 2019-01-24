/*package com.connectivity.vikray.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.connectivity.vikray.entity.Phase;
import com.connectivity.vikray.pojo.ValidResult;
import com.connectivity.vikray.repository.PhaseRepository;
import com.connectivity.vikray.service.PhaseService;

@Repository
public class PhaseServiceImpl{

	@Autowired
	PhaseRepository phaseRepository;
	
	public Phase createPhase(Phase phase) {
		Phase todb= new Phase();
		phaseRepository.save(phase);
		return todb;
	}
	
	public List<Phase> getAllPhase(){
		return phaseRepository.findAll();
	}
}
*/