package ar.edu.unlam.diit.scaw.services.impl;

import org.springframework.beans.factory.annotation.Autowired;

import ar.edu.unlam.diit.scaw.daos.UserDao;
import ar.edu.unlam.diit.scaw.entities.User;
import ar.edu.unlam.diit.scaw.services.UserService;

public class UserServiceImpl implements UserService{
	
	@Autowired
	UserDao userDao;
	//Error creating bean with name 'userService': Injection of autowired dependencies failed; nested exception is org.springframework.beans.factory.BeanCreationException: Could not autowire field: ar.edu.unlam.diit.scaw.daos.UserDao ar.edu.unlam.diit.scaw.services.impl.UserServiceImpl.userDao; nested exception is org.springframework.beans.factory.NoSuchBeanDefinitionException: No qualifying bean of type [ar.edu.unlam.diit.scaw.daos.UserDao] found for dependency: expected at least 1 bean which qualifies as autowire candidate for this dependency. Dependency annotations: {@org.springframework.beans.factory.annotation.Autowired(required=true)}

	@Override
	public User login(User user){
		return userDao.login(user);
	}
	@Override
	public void register(){
		
	}
	
	public UserDao getUserDao() {
		return userDao;
	}
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}	
	
}
