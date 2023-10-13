package com.task.management.system.taskcontrollers;



import java.time.LocalDate;
import java.util.HashMap;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.task.management.system.taskmodel.TaskModel;
import com.task.management.system.taskservices.TaskServices;


@RestController
public class TaskControllers {

	@Autowired
	private TaskServices taskServices;
	
	
	// Home Page
	@GetMapping("/")
	public ModelAndView homePage() {
		String viewName = "home";
		Map<String, Object> model = new HashMap<>();
		model.put("homepage", new TaskModel());
		return new ModelAndView(viewName, model);
	}
	
	
	// Read Registration form
//	@GetMapping("/registration")
//	public ModelAndView getRegistration() {
//		
//		String viewName = "registrationpage";
//		Map<String, Object> model = new HashMap<>();
//		model.put("registerUser", new TaskModel());
//		return new ModelAndView(viewName, model);
//	}
//	
	
	// Registration form
//	@PostMapping("/registration")
//	public ModelAndView registration(TaskModel taskModel) {
//		taskServices.registerForm(taskModel);
//		RedirectView rd = new RedirectView();
//		rd.setUrl("/login");
//		return new ModelAndView(rd);
//	}
//	
	
	// Read Log in
//	@GetMapping("/login")
//	public ModelAndView getLogin() {
//		
//		String viewName = "login";
//		Map<String, Object> model = new HashMap<>();
//		model.put("loginUser", new TaskModel());
//		return new ModelAndView(viewName, model);
//	}
	
	
	// Log in API
//	@PostMapping("/login")
//	public ModelAndView login(@RequestParam(name ="email") String email, @RequestParam(name = "password") String password) {
//		try {
//			TaskModel taskUser =  taskServices.findByEmail(email);
//			if(taskUser != null && taskUser.getPassword().equals(password)) {
//				System.out.println("hello");
//				RedirectView rd = new RedirectView();
//				rd.setUrl("/tasklist");
//				return new ModelAndView(rd);
//			}else {
//				System.out.println("bsk");
//				RedirectView rd = new RedirectView();
//				rd.setUrl("/login");
//				return new ModelAndView(rd);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return null;
//		
//	}

	
	
	// Get All task list
	@GetMapping("/tasklist")
	public ModelAndView getTaskList() {
		String viewName = "tasklist";
		Map<String, Object> model = new HashMap<>();
		model.put("tasklistUser", taskServices.getAllTaskList());
		return new ModelAndView(viewName, model);
	   
	}


	
	// Read task
	@GetMapping("/addtask")
	public ModelAndView getAddTask(@RequestParam (required = false) Integer id) {
		String viewName = "add-task";
		Map<String, Object> model = new HashMap<>();
		
		if(id == null) {
			model.put("addtask", new TaskModel());
		}else {
			model.put("addtask", taskServices.getListByid(id));
		}
		
		return new ModelAndView(viewName, model);
	}
	
		
	
	// Create task API
	@SuppressWarnings("unused")
	@PostMapping("/addtask")
	public ModelAndView addTask(@RequestParam(name = "taskName") String taskName,@RequestParam(name = "description") String description,@RequestParam(name = "dueDate") String dueDate, TaskModel taskModel) {
	       
		TaskModel task = new TaskModel();
	        task.setTaskName(taskName);
	        task.setDescription(description);
	        task.setDueDate(LocalDate.parse(dueDate)); 
	   
	        Integer id = taskModel.getId();
	        if(id == 0) {
	        	 taskServices.saveTask(task);
	        	
	        }else {
	        	taskServices.updateTask(taskModel, id);
	        }
	        RedirectView rd = new RedirectView();
 	        rd.setUrl("/tasklist");
 	        return new ModelAndView(rd);
	}
	
	
	
	
	
	//Delete By Id 
	@GetMapping("/delete/{id}")
	public ModelAndView deleteById(@PathVariable int id) {
		taskServices.deleteListById(id);
		RedirectView rd = new RedirectView();
		rd.setUrl("/tasklist");
		return new ModelAndView(rd);
	}

}
