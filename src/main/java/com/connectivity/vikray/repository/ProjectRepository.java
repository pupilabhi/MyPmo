package com.connectivity.vikray.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.connectivity.vikray.entity.Documents;
import com.connectivity.vikray.entity.Phase;
import com.connectivity.vikray.entity.Project;
import com.connectivity.vikray.entity.ProjectFollower;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long>{

	public void  save(ProjectFollower projectFollower);
	public void  save(Phase phases);
	public void  save(Documents docsTodb);
	public boolean existsByProjectName(String name);

}
