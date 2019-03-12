package com.connectivity.vikray.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.connectivity.vikray.entity.Phase;
import com.connectivity.vikray.pojo.ValidResult;
import com.connectivity.vikray.service.PhaseService;

@RestController
@RequestMapping(value= "/pmo/phase")
public class PhaseController {

	@Autowired
	PhaseService phaseService;
	
	@GetMapping("/getAllPhases")
	public ValidResult getAllPhases() {
		return phaseService.getAllPhase();
	}
	
	@PostMapping("/creatPhase")
	public ValidResult createProjects(@RequestBody Phase phase) {
		return phaseService.createPhase(phase);
	}
	
	
	@PostMapping("/updatePhase")
	public ValidResult updatePhase(@RequestBody Phase phase) {
		return phaseService.updatePhase(phase);
	}
	
	@GetMapping("/phases/{id}")
	public ValidResult getPhasesByProjectID(@PathVariable(value = "id") Long id) {
		return phaseService.getPhasesByProjectId(id);
	}
	
	public ValidResult getPhaseById(@PathVariable(value = "id") Long id) {
		return phaseService.getPhaseById(id);
	}
}
