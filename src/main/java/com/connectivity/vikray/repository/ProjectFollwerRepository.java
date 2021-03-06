package com.connectivity.vikray.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.connectivity.vikray.entity.ProjectFollower;

@Repository
public interface ProjectFollwerRepository extends JpaRepository<ProjectFollower, Long>{

}
