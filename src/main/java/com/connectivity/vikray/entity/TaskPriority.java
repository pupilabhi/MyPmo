package com.connectivity.vikray.entity;
// Generated 27 Dec, 2018 3:06:26 PM by Hibernate Tools 5.2.11.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * TaskPriority generated by hbm2java
 */
@Entity
@Table(name = "TASK_PRIORITY", catalog = "vikrayPmo")
public class TaskPriority implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long id;
	private String color;
	private String name;
	private Set<Task> tasks = new HashSet<Task>(0);

	public TaskPriority() {
	}

	public TaskPriority(long id) {
		this.id = id;
	}

	public TaskPriority(long id, String color, String name, Set<Task> tasks) {
		super();
		this.id = id;
		this.color = color;
		this.name = name;
		this.tasks = tasks;
	}

	@Id
	@Column(name = "ID", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "COLOR")
	public String getColor() {
		return this.color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Column(name = "NAME")
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "taskPriority")
	public Set<Task> getTasks() {
		return this.tasks;
	}

	public void setTasks(Set<Task> tasks) {
		this.tasks = tasks;
	}

}
