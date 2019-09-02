package it.contrader.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import it.contrader.main.ConnectionSingleton;
import it.contrader.model.Student;

public class StudentDAO {

	private final String QUERY_ALL = "SELECT * FROM student";
	private final String QUERY_CREATE = " INSERT INTO student (name, surname, idUser) VALUES (?,?,?)";
	private final String QUERY_READ= "SELECT * FROM student WHERE id=?";
	private final String QUERY_UPDATE = "UPDATE student SET name=? , surname=? , idUser=? WHERE id=?";
	private final String QUERY_DELETE = " DELETE FROM student WHERE id=?";
	
	public StudentDAO() {
		
	}
	public List<Student> getAll(){
		List<Student> studentList = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY_ALL);
			Student student;
			while(resultSet.next()) {
				int id = resultSet.getInt("id");
				String name= resultSet.getString("name");
				String surname = resultSet.getString ("surname");
				int idUser= resultSet.getInt("idUser");	
				student = new Student (name, surname, idUser);
				student.setId(id);
				studentList.add(student);
				
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return studentList;
	}
	public boolean insert (Student studentToInsert) {
		Connection connection = ConnectionSingleton.getInstance();
		
		
		}
	}
}
