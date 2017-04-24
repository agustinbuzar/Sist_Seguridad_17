package ar.edu.unlam.diit.scaw.daos.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import ar.edu.unlam.diit.scaw.daos.UserDao;
import ar.edu.unlam.diit.scaw.entities.User;

public class UserDaoImpl implements UserDao{
	
	@Autowired
	NamedParameterJdbcTemplate jdbcTemplate; 
	
	@Override
	public User login(User user){
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("username", user.getUsername());
		params.put("password", user.getPassword());
		String sql = "SELECT * FROM USER_ WHERE USERNAME = :username AND PASSWORD = :password";
		List<User> result = jdbcTemplate.query(sql,  params, new UserMapper());
		User result_user = result.get(0);
		return result_user;
	}
	@Override
	public void register(){
		
	}
	
	
	
	public NamedParameterJdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	public void setJdbcTemplate(NamedParameterJdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}



	private static final class UserMapper implements RowMapper<User>{
		
		public User mapRow(ResultSet rs, int rowNum) throws SQLException {
			User user = new User();
			user.setUsername(rs.getString("USERNAME"));
			user.setPassword(rs.getString("PASSWORD"));
			user.setEmail(rs.getString("EMAIL"));
			user.setCondition(rs.getString("CONDITION"));
			return user;
		}
	}
}
