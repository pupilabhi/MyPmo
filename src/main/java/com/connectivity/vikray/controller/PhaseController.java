package com.connectivity.vikray.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.connectivity.vikray.entity.Phase;
import com.connectivity.vikray.payload.ApiResponse;
import com.connectivity.vikray.service.PhaseService;

@RestController
@RequestMapping(value= "/pmo/phase",produces = "application/hal+json")
public class PhaseController {

	@Autowired
	PhaseService phaseService;
	
	
	@PostMapping("/creatPhase")
	public ResponseEntity<ApiResponse> createProjects(@RequestBody Phase phase) {
		return phaseService.createPhase(phase);
	}
	
	
	@PostMapping("/updatePhase")
	public ResponseEntity<ApiResponse> updatePhase(@RequestBody Phase phase) {
		return phaseService.updatePhase(phase);
	}
	
	@GetMapping("/phases/{id}")
	public ResponseEntity<ApiResponse> getPhasesByProjectID(@PathVariable(value = "id") Long id) {
		return phaseService.getPhasesByProjectId(id);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ApiResponse> getPhaseById(@PathVariable(value = "id") Long id) {
		return phaseService.getPhaseById(id);
	}
}
