package com.connectivity.vikray.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "status_item")
public class StatusItem {

	private Long id;
	private String type;
	private String statusConstant;
	private String description;
	
	
	
	@Id
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name = "status_type")
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	@Column(name = "status_constant")
	public String getStatusConstant() {
		return statusConstant;
	}
	public void setStatusConstant(String statusConstant) {
		this.statusConstant = statusConstant;
	}
	
	@Column(name = "description")
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
}
