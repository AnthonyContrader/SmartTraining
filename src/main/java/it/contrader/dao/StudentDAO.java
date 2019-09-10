package it.contrader.dao;

import java.sql.*;

import it.contrader.utils.ConnectionSingleton;
import java.util.ArrayList;
import java.util.List;
import it.contrader.model.Student;

public class StudentDAO implements DAO<Student> {
	
	private final String QUERY_ALL = "SELECT * FROM student";
	private final String QUERY_CREATE = "INSERT INTO student (name, surname, idUser) VALUES (?,?,?)";
	private final String QUERY_READ = "SELECT * FROM student WHERE id=?";
	private final String QUERY_UPDATE = "UPDATE student SET name=?, surname=?, idUser=? WHERE id=?";
	private final String QUERY_DELETE = "DELETE FROM student WHERE id=?";

	public StudentDAO() {
		
	}
	
	public List<Student> getAll(){
		List<Student> studentsList= new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY_ALL);
			Student student;
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				String surname = resultSet.getString("surname");
				int idUser = resultSet.getInt("idUser");
				student = new Student(name, surname, idUser);
				student.setId(id);
				studentsList.add(student);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return studentsList;
	}
	public boolean insert(Student studentToInsert) {
		Connection connection = ConnectionSingleton.getInstance();
		try {	
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_CREATE);
			preparedStatement.setString(1, studentToInsert.getName());
			preparedStatement.setString(2, studentToInsert.getSurname());
			preparedStatement.setInt(3, studentToInsert.getIdUser());
			preparedStatement.execute();
			return true;
		} catch (SQLException e) {
			return false;
		}
	}
	public Student read(int studentId) {
			Connection connection = ConnectionSingleton.getInstance();
			try {


				PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
				preparedStatement.setInt(1, studentId);
				ResultSet resultSet = preparedStatement.executeQuery();
				resultSet.next();
				String name,surname;
				int idUser;

				name = resultSet.getString("name");
				surname = resultSet.getString("surname");
				idUser = resultSet.getInt("idUser");
				Student student = new Student(name, surname, idUser);
				student.setId(resultSet.getInt("id"));

				return student;
			} catch (SQLException e) {
				return null;
			}

		}

		public boolean update(Student studentToUpdate) {
			Connection connection = ConnectionSingleton.getInstance();

			// Check if id is present
			if (studentToUpdate.getId() == 0)
				return false;

			Student studentRead = read(studentToUpdate.getId());
			if (!studentRead.equals(studentToUpdate)) {
				try {
					// Fill the userToUpdate object
					if (studentToUpdate.getName() == null || studentToUpdate.getName().equals("")) {
						studentToUpdate.setName(studentRead.getName());
					}

					if (studentToUpdate.getSurname() == null || studentToUpdate.getSurname().equals("")) {
						studentToUpdate.setSurname(studentRead.getSurname());
					}

					if (studentToUpdate.getIdUser() == 0 ) {
						studentToUpdate.setIdUser(studentRead.getIdUser());
					}

					// Update the user
					PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE);
					preparedStatement.setString(1, studentToUpdate.getName());
					preparedStatement.setString(2, studentToUpdate.getSurname());
					preparedStatement.setInt(3, studentToUpdate.getIdUser());
					preparedStatement.setInt(4, studentToUpdate.getId());
					int a = preparedStatement.executeUpdate();
					if (a > 0)
						return true;
					else
						return false;

				} catch (SQLException e) {
					return false;
				}
			}

			return false;

		}

		public boolean delete(int id) {
			Connection connection = ConnectionSingleton.getInstance();
			try {
				PreparedStatement preparedStatement = connection.prepareStatement(QUERY_DELETE);
				preparedStatement.setInt(1, id);
				int n = preparedStatement.executeUpdate();
				if (n != 0)
					return true;

			} catch (SQLException e) {
			}
			return false;
		}
}
