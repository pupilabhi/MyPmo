package com.connectivity.vikray.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.connectivity.vikray.entity.UserDetails;

public interface LoginRepository extends JpaRepository<UserDetails, Long>{

}
