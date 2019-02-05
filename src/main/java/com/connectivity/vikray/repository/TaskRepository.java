package com.connectivity.vikray.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.connectivity.vikray.entity.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long>{

}
