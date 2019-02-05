package com.connectivity.vikray.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.connectivity.vikray.entity.Phase;
import com.connectivity.vikray.entity.Project;
import com.connectivity.vikray.pojo.ValidResult;
import com.connectivity.vikray.service.PhaseService;

@RestController
@RequestMapping(value= "/phase")
public class PhaseController {

	@Autowired
	PhaseService phaseService;
	
	public ValidResult getAllPhases() {
		return phaseService.getAllPhase();
	}
	
	@PostMapping("/creatPhase")
	public ValidResult createProjects(@RequestBody Phase phase) {
		return phaseService.createPhase(phase);
	}

}
