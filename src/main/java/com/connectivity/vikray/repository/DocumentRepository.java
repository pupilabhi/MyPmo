package com.connectivity.vikray.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.connectivity.vikray.entity.Documents;

@Repository
public interface DocumentRepository extends JpaRepository<Documents, Long>{

}
