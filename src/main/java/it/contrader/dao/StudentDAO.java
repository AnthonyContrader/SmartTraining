package it.contrader.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import it.contrader.utils.ConnectionSingleton;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import it.contrader.model.Student;

import com.mysql.jdbc.Statement;

import it.contrader.model.Student;
import it.contrader.utils.ConnectionSingleton;

public class StudentDAO implements DAO<Student>{
	
	private final String QUERY_ALL = "SELECT * FROM student";
	private final String QUERY_CREATE = "INSERT INT student (name, surname, idUser) VALUES (?,?,?)";
	private final String QUERY_READ = "SELECT * FROM student WHERE id=?";
	private final String QUERY_UPDATE = "UPDATE student SET name=?, surname=?, idUser=? WHERE id=? ";
	private final String QUERY_DELETE = "DELETE FROM student WHERE id=?";
	
	public StudentDAO() {
		
	}

	@Override
	public List<Student> getAll() {
		List<Student> studentList = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			Statement statement =  (Statement) connection.createStatement();
			ResultSet resultset = statement.executeQuery(QUERY_ALL);
			Student student;
			while(resultset.next()) {
				int id = resultset.getInt("id");
				String name = resultset.getString("name");
				String surname = resultset.getString("surname");
				int idUser = resultset.getInt("idUser");
				student = new Student(name, surname, idUser);
				student.setId(id);
				studentList.add(student);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return studentList;
		// TODO Auto-generated method stub
	}

	@Override
	public Student read(int studentId) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
			preparedStatement.setInt(1, studentId);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			String name, surname;
			int idUser;
			
			name = resultSet.getString("name");
			surname = resultSet.getString("surname");
			idUser = resultSet.getInt("IdUser");
			Student student = new Student(name, surname, idUser);
			student.setId(resultSet.getInt("id"));
			
			return student;
		}catch (SQLException e) {
			return null;
		}
		// TODO Auto-generated method stub
	}

	@Override
	public boolean insert(Student studentToInsert) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_CREATE);
			preparedStatement.setString(1, studentToInsert.getName());
			preparedStatement.setString(2, studentToInsert.getSurname());
			preparedStatement.setInt(3, studentToInsert.getIdUser());
			preparedStatement.execute();
			return true;
		}catch (SQLException e) {
			return false;
		}
		// TODO Auto-generated method stub
	}

	@Override
	public boolean update(Student studentToUpdate) {
		Connection connection = ConnectionSingleton.getInstance();
		
		if(studentToUpdate.getId()==0)
			return false;
		Student studentRead = read(studentToUpdate.getId());
		if(!studentRead.equals(studentToUpdate)) {
			try {
				if(studentToUpdate.getName() == null || studentToUpdate.getName().equals("")) {
					studentToUpdate.setName(studentRead.getName());
				}
				if(studentToUpdate.getSurname() == null || studentToUpdate.getSurname().equals("")) {
					studentToUpdate.setSurname(studentRead.getSurname());
				}
				if (studentToUpdate.getIdUser() == 0) {
					studentToUpdate.setIdUser(studentRead.getIdUser());
				}
				
				PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE);
				preparedStatement.setString(1, studentToUpdate.getName());
				preparedStatement.setString(2, studentToUpdate.getSurname());
				preparedStatement.setInt(3, studentToUpdate.getIdUser());
				preparedStatement.setInt(4, studentToUpdate.getId());
				int a = preparedStatement.executeUpdate();
				if(a > 0)
					return true;
				else 
					return false;
			}catch (SQLException e) {
				return false;
			}
		}
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int id) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_DELETE);
			preparedStatement.setInt(1, id);
			int n = preparedStatement.executeUpdate();
			if(n != 0)
				return true;
			
		}catch (SQLException e ) {	
		}
		// TODO Auto-generated method stub
		return false;
	}

}
