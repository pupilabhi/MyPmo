package com.connectivity.vikray.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonBackReference;

//New Entity class added for vikray-PMO by Pawan @18-01-2019
@Entity
@Table(name = "PHASE_FOLLOWER", catalog = "vikrayPmo")
@EntityListeners(AuditingEntityListener.class)
public class PhaseFollower extends Auditable<String> implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private long id;
	private Phase phaseFk;
	private UserDetails userDetailsFk;
	
	public PhaseFollower() {
		
	}
	
	public PhaseFollower(long id) {
		this.id= id;
	}
	

	public PhaseFollower(long id, Phase phaseFk, UserDetails userDetailsFk) {
		super();
		this.id = id;
		this.phaseFk = phaseFk;
		this.userDetailsFk = userDetailsFk;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "phaseFk")
	@JsonBackReference(value="p_ref")
	public Phase getPhaseFk() {
		return phaseFk;
	}
	
	public void setPhaseFk(Phase phase) {
		this.phaseFk = phase;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "userFk")
	public UserDetails getUserDetailsFk() {
		return userDetailsFk;
	}

	public void setUserDetailsFk(UserDetails userDetailsFk) {
		this.userDetailsFk = userDetailsFk;
	}
	
	
}
