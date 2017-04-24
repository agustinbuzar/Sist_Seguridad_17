package ar.edu.unlam.diit.scaw.daos.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import ar.edu.unlam.diit.scaw.daos.TaskDao;
import ar.edu.unlam.diit.scaw.entities.Task;

public class TaskDaoImpl implements TaskDao{
	
	@Autowired
	NamedParameterJdbcTemplate jdbcTemplate; 
	
	public TaskDaoImpl(){
		super();
	}
	
	@Override
	public void addTask(Task task){		
		
		String sql = "INSERT INTO TASK (MODE, FIRSTNAME_TO_ADD, LASTNAME_TO_ADD, EMAIL_TO_ADD, TARGET_REGISTER) VALUES (:mode, :firstname_to_add, :lastname_to_add, :email_to_add, :target_register)";

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("mode", task.getMode());
		params.put("firstname_to_add", task.getFirstname_to_add());
		params.put("lastname_to_add", task.getLastname_to_add());
		params.put("email_to_add", task.getEmail_to_add());
		params.put("target_register", task.getTarget_register());
		
		jdbcTemplate.update(sql, params);
		
		
		/* IMPORTANTE: LOS METODOS FUNCIONAN APARENTEMENTE... PERO NO HAY PERSISTENCIA ENTRE VISTAS...*/
		
	}

	@Override
	public List<Task> listAll() {
		String sql = "SELECT * FROM TASK";
		Map<String, Object> params = new HashMap<String, Object>();
		List<Task> result = jdbcTemplate.query(sql, params, new TaskMapper());
		return result;
	}	
	@Override
	public void aproveTask(Task task){
		Map<String, Object> params = new HashMap<String, Object>();
		String sql = null;
		String mode = task.getMode();
		params.put("id", task.getId());
		params.put("firstname_to_add", task.getFirstname_to_add());
		params.put("lastname_to_add", task.getLastname_to_add());
		params.put("email_to_add", task.getEmail_to_add());
		params.put("target_register", task.getTarget_register());	
		
		switch(mode)
		{
			case "ALTA":			
				sql = "UPDATE TASK SET (STATE) = 'COMPLETADA' WHERE ID = :id";	//CAMBIO EL ESTADO DE LA TAREA A COMPLETADA		
				jdbcTemplate.update(sql, params);								//EJECUTO EL LA SENTENCIA SQL
				sql = "INSERT INTO PERSON (FIRSTNAME, LASTNAME, EMAIL) VALUES(:firstname_to_add, :lastname_to_add, :email_to_add)";
				System.out.println("Vamos a dar de alta, maquina");				
				break;
			case "BAJA":				
				sql = "UPDATE TASK SET (STATE) = 'COMPLETADA' WHERE ID = :id"; 
				jdbcTemplate.update(sql, params);
				sql = "DELETE FROM PERSON WHERE ID = :target_register";				
				break;
			case "MODIFICACION":
				sql = "UPDATE PERSON SET (FIRSTNAME) = :firstname_to_add, (LASTNAME) = :lastname_to_add, (EMAIL) = :email_to_add)";
				jdbcTemplate.update(sql, params);				
				//NO FUNCIONA CON CAMPOS INDIVIDUALES...
				break;
		}			
		System.out.println(jdbcTemplate.update(sql, params));
		
	}
	
	public NamedParameterJdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(NamedParameterJdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	private static final class TaskMapper implements RowMapper<Task>{
		
		public Task mapRow(ResultSet rs, int rowNum) throws SQLException {
			Task task = new Task();
			task.setId(rs.getInt("id"));
			task.setMode(rs.getString("mode"));
			task.setFirstname_to_add(rs.getString("firstname_to_add"));
			task.setLastname_to_add(rs.getString("lastname_to_add"));
			task.setEmail_to_add(rs.getString("email_to_add"));
			task.setState(rs.getString("state"));
			
			System.out.println("Tareas " +rowNum);

			return task;
		}
	}
}
