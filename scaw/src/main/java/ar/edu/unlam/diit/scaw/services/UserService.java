package ar.edu.unlam.diit.scaw.services;

import ar.edu.unlam.diit.scaw.entities.User;

public interface UserService {
	
	public User login(User user);
	public void register();
}
