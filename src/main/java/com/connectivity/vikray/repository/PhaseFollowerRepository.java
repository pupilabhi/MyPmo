package com.connectivity.vikray.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.connectivity.vikray.entity.PhaseFollower;

@Repository
public interface PhaseFollowerRepository extends JpaRepository<PhaseFollower, Long> {

}