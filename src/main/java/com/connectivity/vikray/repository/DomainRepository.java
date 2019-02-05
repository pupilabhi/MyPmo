package com.connectivity.vikray.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.connectivity.vikray.entity.Domain;

public interface DomainRepository extends JpaRepository<Domain, Long> {

}
