package com.connectivity.vikray.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.connectivity.vikray.entity.TaskStatus;

public interface TaskStatusRepository extends JpaRepository<TaskStatus, Long>{

}
