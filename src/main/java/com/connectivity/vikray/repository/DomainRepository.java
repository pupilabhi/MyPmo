package com.connectivity.vikray.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.connectivity.vikray.entity.Domain;

@Repository
public interface DomainRepository extends JpaRepository<Domain, Long> {

}
