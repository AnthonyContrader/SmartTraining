package it.contrader.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import it.contrader.main.ConnectionSingleton;
import it.contrader.model.Group;

public class GroupDAO {
	
	private final String QUERY_ALL = "SELECT * FROM smarttraining.group";
	private final String QUERY_CREATE = "INSERT INTO smarttraining.group (id, idStudent) VALUES (?,?)";
	private final String QUERY_READ = "SELECT * FROM smarttraining.group WHERE id=?";
	private final String QUERY_UPDATE = "UPDATE smarttraining.group SET idStudent=? WHERE id=?";
	private final String QUERY_DELETE = "DELETE FROM smarttraining.group WHERE id=?";
	
		
	public GroupDAO() {

	}

	public List<Group> getAll() {
		List<Group> groupList = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY_ALL);
			Group group;
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				int idStudent = resultSet.getInt("idStudent");
				group = new Group(id, idStudent);
				group.setId(id);
				groupList.add(group);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return groupList;
	}

	public boolean insert(Group groupToInsert) {
		Connection connection = ConnectionSingleton.getInstance();
		try {	
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_CREATE);
			preparedStatement.setInt(1, groupToInsert.getId());
			preparedStatement.setInt(2, groupToInsert.getIdStudent());
			preparedStatement.execute();
			return true;
		} catch (SQLException e) {
			return false;
		}

	}

	public Group read(int groupId) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
			preparedStatement.setInt(1, groupId);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			int id, idStudent;

			id = resultSet.getInt("id");
			idStudent = resultSet.getInt("idStudent");
			Group group = new Group(id, idStudent);
			group.setId(resultSet.getInt("id"));

			return group;
		} catch (SQLException e) {
			return null;
		}

	}
	
	public boolean update(Group groupToUpdate) {
		Connection connection = ConnectionSingleton.getInstance();

		// Check if id is present
		if (groupToUpdate.getId() == 0)
			return false;

		Group groupRead = read(groupToUpdate.getId());
		if (!groupRead.equals(groupToUpdate)) {
			try {

				if (groupToUpdate.getIdStudent() == 0) {
					groupToUpdate.setIdStudent(groupRead.getIdStudent());
				}

				// Update the group
				PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE);
				preparedStatement.setInt(1, groupToUpdate.getIdStudent());
				preparedStatement.setInt(2, groupToUpdate.getId());
				int a = preparedStatement.executeUpdate();
				System.out.println("true");
				if (a > 0)
					return true;
				else
					return false;

			} catch (SQLException e) {
				System.out.println("false");
				return false;
			}catch (Exception ex){}
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
