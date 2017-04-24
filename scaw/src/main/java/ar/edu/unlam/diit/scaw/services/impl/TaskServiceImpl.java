package ar.edu.unlam.diit.scaw.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import ar.edu.unlam.diit.scaw.daos.TaskDao;
import ar.edu.unlam.diit.scaw.entities.Task;
import ar.edu.unlam.diit.scaw.services.TaskService;

public class TaskServiceImpl implements TaskService{
	
	@Autowired
	TaskDao taskDao;
	
	@Override
	public void addTask(Task task){
		taskDao.addTask(task);
	}
	@Override
	public List<Task> listAll() {
		List<Task> list = taskDao.listAll();
		return list;
	}	
	@Override
	public void aproveTask(Task task) {
		taskDao.aproveTask(task);
	}
	
	public TaskDao getTaskDao() {
		return taskDao;
	}

	public void setTaskDao(TaskDao taskdao) {
		this.taskDao = taskdao;
	}





	
	
	
}
