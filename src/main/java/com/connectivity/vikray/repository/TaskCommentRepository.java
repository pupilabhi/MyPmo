package com.connectivity.vikray.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.connectivity.vikray.entity.TaskComment;

public interface TaskCommentRepository extends JpaRepository<TaskComment, Long>{

}
