package com.task.management.system.taskmodel;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "taskmanagementsystem")
public class TaskModel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String taskName;
	private String description;
	private LocalDate dueDate;
	
	

	public String getTaskName() {
		return taskName;
	}
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public LocalDate getDueDate() {
		return dueDate;
	}
	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}
	public  int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}	
}
