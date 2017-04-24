package ar.edu.unlam.diit.scaw.entities;

public class Task {
	
	private Integer id;
	private String mode;
	private String firstname_to_add;
	private String lastname_to_add;
	private String email_to_add;
	private String state;
	private Integer target_register;

	
	
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

	public Integer getTarget_register() {
		return target_register;
	}

	public void setTarget_register(Integer target_register) {
		this.target_register = target_register;
	}
	

	
	
}
