package com.connectivity.vikray.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.connectivity.vikray.entity.TaskPriority;

@Repository
public interface TaskPriorityRepository extends JpaRepository<TaskPriority, Long> {

}
