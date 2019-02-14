package com.connectivity.vikray.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.connectivity.vikray.entity.StatusItem;

@Repository
public interface StatusRepository extends JpaRepository<StatusItem, Long> {

}
