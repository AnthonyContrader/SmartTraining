package it.contrader.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import it.contrader.model.Group;
import it.contrader.utils.ConnectionSingleton;

public class GroupDAO implements DAO<Group> {
	
	private final String QUERY_ALL = "SELECT * FROM smarttraining.group";
	private final String QUERY_CREATE = "INSERT INTO smarttraining.group (idStudent, groupcol ) VALUES (?,?)";
	private final String QUERY_READ = "SELECT * FROM smarttraining.group WHERE id=?";
	private final String QUERY_UPDATE = "UPDATE smarttraining.group SET idStudent=?, groupcol=? WHERE id=?";
	private final String QUERY_DELETE = "DELETE FROM smarttraining.group WHERE id=?";
	
	public GroupDAO() {

	}
	
	public List<Group> getAll() {
		List<Group> groupsList = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY_ALL);
			Group group;
			while (resultSet.next()) {
				
				int id = resultSet.getInt("id");
				int idStudent = resultSet.getInt("idStudent");
				String groupcol = resultSet.getString("groupcol");
				group = new Group(idStudent, groupcol);
				group.setId(id);
				groupsList.add(group);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return groupsList;
	}

	public boolean insert(Group groupToInsert) {
		Connection connection = ConnectionSingleton.getInstance();
		try {	
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_CREATE);
			preparedStatement.setInt(1, groupToInsert.getIdStudent());
			preparedStatement.setString(2, groupToInsert.getGroupcol());
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
			int idStudent;
			String groupcol;

			idStudent = resultSet.getInt("idStudent");
			groupcol = resultSet.getString("groupcol");
			Group group = new Group(idStudent, groupcol);
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
//fare modifica sul controllo del groupcol
				// Fill the groupToUpdate object
			    if (groupToUpdate.getIdStudent() == 0) {
					groupToUpdate.setIdStudent(groupRead.getIdStudent()); 
				}
				 
				if (groupToUpdate.getGroupcol() == null || groupToUpdate.getGroupcol().equals("")){
					groupToUpdate.setGroupcol(groupRead.getGroupcol());
				}

				// Update the group
				PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE);
				preparedStatement.setInt(1, groupToUpdate.getIdStudent());
				preparedStatement.setString(2, groupToUpdate.getGroupcol());
				preparedStatement.setInt(3, groupToUpdate.getId());
				int a = preparedStatement.executeUpdate();
				if (a > 0) {
					return true;
				}
				else {
					return false;
				}

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
