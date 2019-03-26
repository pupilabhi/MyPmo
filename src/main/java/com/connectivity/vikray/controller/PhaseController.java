package com.connectivity.vikray.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.connectivity.vikray.entity.Phase;
import com.connectivity.vikray.payload.ApiResponse;
import com.connectivity.vikray.service.PhaseService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value= "/pmo/phase",produces = "application/hal+json")
@Api("Phase Services")
public class PhaseController {

	@Autowired
	PhaseService phaseService;
	
	
	@ApiOperation(value = "Create project")
	@PostMapping("/creatPhase")
	public ResponseEntity<ApiResponse> createProjects(@RequestBody Phase phase) {
		return phaseService.createPhase(phase);
	}
	
	@ApiOperation(value = "Update project")
	@PutMapping("/updatePhase")
	public ResponseEntity<ApiResponse> updatePhase(@RequestBody Phase phase) {
		return phaseService.updatePhase(phase);
	}
	
	@ApiOperation(value = "Returns Phases by project id")
	@GetMapping("/phases/{id}")
	public ResponseEntity<ApiResponse> getPhasesByProjectID(@PathVariable(value = "id") Long id) {
		return phaseService.getPhasesByProjectId(id);
	}

	@ApiOperation(value = "Returns Phase By id")
	@GetMapping("/{id}")
	public ResponseEntity<ApiResponse> getPhaseById(@PathVariable(value = "id") Long id) {
		return phaseService.getPhaseById(id);
	}
}
