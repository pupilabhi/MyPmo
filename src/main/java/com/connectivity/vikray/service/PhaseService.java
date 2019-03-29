package com.connectivity.vikray.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.connectivity.vikray.constant.VikrayPmoMessageConstant;
import com.connectivity.vikray.entity.Phase;
import com.connectivity.vikray.payload.ApiResponse;
import com.connectivity.vikray.pojo.ValidResult;
import com.connectivity.vikray.serviceImpl.PhaseServiceImpl;

@Service("PhaseService")
public class PhaseService {

	@Autowired
	PhaseServiceImpl phaseServiceImpl;
	
	@Autowired
	ValidResult result;
	
	public ResponseEntity<ApiResponse> createPhase(Phase phase) {
		ResponseEntity<ApiResponse> response = phaseServiceImpl.createPhase(phase);
			return response;
	}
	
	public ResponseEntity<ApiResponse> updatePhase(Phase phase) {
		ResponseEntity<ApiResponse> response= phaseServiceImpl.updatePhase(phase);
		return response;
	}

	public ResponseEntity<ApiResponse> getPhasesByProjectId(Long projectId) {
		ResponseEntity<ApiResponse> response= phaseServiceImpl.getPhasesByProjectId(projectId);
		return response;
	}

	public ResponseEntity<ApiResponse> getPhaseById(Long id) {
		ResponseEntity<ApiResponse> response= phaseServiceImpl.getPhaseById(id);
		return response;
	}

	public ResponseEntity<ApiResponse> getPhaseByGuId(String guid) {
		ResponseEntity<ApiResponse> response= phaseServiceImpl.getPhaseByGuId(guid);
		return response;
	}
}
