package ar.edu.unlam.diit.scaw.daos;

import ar.edu.unlam.diit.scaw.entities.User;

public interface UserDao {
	
	public User login(User user);
	public void register();
}
