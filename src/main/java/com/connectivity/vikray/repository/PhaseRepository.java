package com.connectivity.vikray.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.connectivity.vikray.entity.Phase;
import com.connectivity.vikray.entity.Project;

@Repository
public interface PhaseRepository extends JpaRepository<Phase, Long>{

	public List<Phase>  findByProjectFk(Project projectFk);
	public Phase findByGuid(String guid);
	public boolean existsByGuid(String guid);
	
}