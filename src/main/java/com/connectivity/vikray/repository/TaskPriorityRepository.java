package com.connectivity.vikray.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.connectivity.vikray.entity.TaskPriority;

public interface TaskPriorityRepository extends JpaRepository<TaskPriority, Long> {

}
