package ar.edu.unlam.diit.scaw.daos;

import java.util.List;

import ar.edu.unlam.diit.scaw.entities.Task;

public interface TaskDao {
	public void addTask(Task task);

	public List<Task> listAll();
	public void aproveTask(Task task);

}
