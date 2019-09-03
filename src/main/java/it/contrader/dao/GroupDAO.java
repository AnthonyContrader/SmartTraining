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
	
	private final String QUERY_ALL = "SELECT * FROM group";
	private final String QUERY_READ = "SELECT * FROM group WHERE id=?";
	
	
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

	
}
