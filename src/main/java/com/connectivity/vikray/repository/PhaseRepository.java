package com.connectivity.vikray.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.connectivity.vikray.entity.Phase;

@Repository
public interface PhaseRepository extends JpaRepository<Phase, Long>{

}