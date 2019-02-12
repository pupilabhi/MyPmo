package com.connectivity.vikray.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.connectivity.vikray.entity.Documents;
import com.connectivity.vikray.entity.Phase;
import com.connectivity.vikray.entity.ProjectFollower;
import com.connectivity.vikray.entity.Task;
import com.connectivity.vikray.entity.TaskCcUser;
import com.connectivity.vikray.entity.TaskComment;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
	
	/*public void  save(Documents docsTodb);
	public void  save(TaskComment taskComment);
	public void  save(TaskCcUser taskCcUser);*/
}
