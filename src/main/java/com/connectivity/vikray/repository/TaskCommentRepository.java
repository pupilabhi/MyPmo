package com.connectivity.vikray.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.connectivity.vikray.entity.TaskComment;

@Repository
public interface TaskCommentRepository extends JpaRepository<TaskComment, Long>{

}
