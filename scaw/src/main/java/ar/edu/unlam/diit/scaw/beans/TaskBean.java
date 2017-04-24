package ar.edu.unlam.diit.scaw.beans;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ar.edu.unlam.diit.scaw.entities.Task;
import ar.edu.unlam.diit.scaw.services.TaskService;

@ManagedBean(name = "taskBean", eager = true)
@RequestScoped
public class TaskBean implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private Integer id = null;
	private String mode = "ALTA";
	private String firstname_to_add = null;
	private String lastname_to_add = null;
	private String email_to_add = null;
	private String state = null;
	private String target_register = null; //NO SE USA
	
	//Spring Inject
	ApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"beans.xml"});
	TaskService service = (TaskService) context.getBean("taskService");
		
	public TaskBean(){
		super();
	}
	
	public void addTask(Integer target_register){
		System.out.println(target_register);

		Task task = new Task();
		task.setMode(this.mode);
		task.setFirstname_to_add(this.firstname_to_add);
		task.setLastname_to_add(this.lastname_to_add);
		task.setEmail_to_add(this.email_to_add);
		task.setTarget_register(target_register);
		service.addTask(task);				
	}
	public List<Task> listAll(){
		List<Task> list = service.listAll();
		return list;
	}
	public void aproveTask(Task task){		
		service.aproveTask(task);
	}
	public String createTask(Integer id_register){
		return "nuevatarea";
	}

	
	
	
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public String getFirstname_to_add() {
		return firstname_to_add;
	}

	public void setFirstname_to_add(String firstname_to_add) {
		this.firstname_to_add = firstname_to_add;
	}

	public String getLastname_to_add() {
		return lastname_to_add;
	}

	public void setLastname_to_add(String lastname_to_add) {
		this.lastname_to_add = lastname_to_add;
	}

	public String getEmail_to_add() {
		return email_to_add;
	}

	public void setEmail_to_add(String email_to_add) {
		this.email_to_add = email_to_add;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getTarget_register() {
		return target_register;
	}

	public void setTarget_register(String target_register) {
		this.target_register = target_register;
	}
	
}
