package com.task.management.system.taskrepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.task.management.system.taskmodel.TaskModel;

@Repository
public interface TaskRepository extends JpaRepository<TaskModel, Integer> {


//	TaskModel findByEmail(String email);
}
