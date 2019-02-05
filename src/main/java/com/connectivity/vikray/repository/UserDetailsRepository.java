package com.connectivity.vikray.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.connectivity.vikray.entity.UserDetails;

public interface UserDetailsRepository extends JpaRepository<UserDetails, Long>{

	
}
