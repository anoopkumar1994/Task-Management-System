package com.task.management.system.taskservices;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.task.management.system.taskmodel.TaskModel;
import com.task.management.system.taskrepository.TaskRepository;

@Service
public class TaskServices {
	
	@Autowired
	private TaskRepository taskRepository;
	
//	public void registerForm(TaskModel taskModel) {
//		 taskRepository.save(taskModel);
//		
//	}

//	 public TaskModel findByEmail(String email) {
//	        return taskRepository.findByEmail(email);
//	    }

	public TaskModel saveTask(TaskModel task) {
		return taskRepository.save(task);
		
	}
	
	public TaskModel getListByid(Integer id) {
		return taskRepository.findById(id).get();
	}

	public List<TaskModel> getAllTaskList() {
		return taskRepository.findAll();
	}

	public void deleteListById(int id) {
		taskRepository.deleteById(id);
	}

	

	public TaskModel updateTask(TaskModel taskmodel, Integer id) {
		
		TaskModel taskUpdate = taskRepository.findById(id).get();
		taskUpdate.setTaskName(taskmodel.getTaskName());
		taskUpdate.setDescription(taskmodel.getDescription());
		taskUpdate.setDueDate(taskmodel.getDueDate());
		
		return taskRepository.save(taskUpdate);
	}



}
