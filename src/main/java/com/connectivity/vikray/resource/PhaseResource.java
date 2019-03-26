package com.connectivity.vikray.resource;

import org.springframework.hateoas.ResourceSupport;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import com.connectivity.vikray.controller.PhaseController;
import com.connectivity.vikray.entity.Phase;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PhaseResource extends ResourceSupport{

	public Phase phase;
	
	public PhaseResource(Phase phase) {
		this.phase = phase;
		long id = phase.getId();
		add(linkTo(PhaseController.class).withRel("Phases"));
		add(linkTo(methodOn(PhaseController.class).getPhaseById(id)).withSelfRel());
	}
	
	public PhaseResource(Phase phase, long id) {
		this.phase = phase;
		add(linkTo(methodOn(PhaseController.class).getPhaseById(id)).withSelfRel());
		add(linkTo(methodOn(PhaseController.class).getPhasesByProjectID(id)).withRel("ByProjectID")); 
	}
}
