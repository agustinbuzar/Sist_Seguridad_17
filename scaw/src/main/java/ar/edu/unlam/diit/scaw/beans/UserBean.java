package ar.edu.unlam.diit.scaw.beans;
import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ar.edu.unlam.diit.scaw.entities.User;
import ar.edu.unlam.diit.scaw.services.UserService;

@ManagedBean(name = "userBean", eager = true)
@RequestScoped
public class UserBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String username = null;
	private String password = null;
	private String email = null;
	private String condition = null;

	
	//Spring Inject
	ApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"beans.xml"});
	UserService service = (UserService) context.getBean("userService");
	
	public UserBean(){
		super();
	}
	
	public String login(){
		
		User user = new User();
		user.setUsername(this.username);
		user.setPassword(this.password);		
		
		User user_logged = service.login(user); 
		if(user_logged.getCondition().equals("ADMIN_USER"))
		{
			return "admin";
		}
		else
		{
			return "welcome";
		}		
		
	}
	
	
	
	
	
	
	
	
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public UserBean(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
}
