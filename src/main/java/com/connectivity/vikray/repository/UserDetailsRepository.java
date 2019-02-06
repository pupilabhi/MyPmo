package com.connectivity.vikray.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.connectivity.vikray.entity.UserDetails;

@Repository
public interface UserDetailsRepository extends JpaRepository<UserDetails, Long>{

	Optional<UserDetails> findByUserLoginIdOrUserEmail(String userLoginId, String userEmail);

	boolean existsByUserLoginId(String userLoginId);

	boolean existsByUserEmail(String userEmail);

	
}
