package it.contrader.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import it.contrader.main.ConnectionSingleton;
import it.contrader.model.Training;

public class TrainingDAO {
	private final String QUERY_ALL = "SELECT * FROM training";
	private final String QUERY_CREATE = "INSERT INTO training (nameTraining, idGroup, idStudent) VALUES (?, ?, ?)";
	private final String QUERY_READ = "SELECT * FROM training WHERE id=?";
	private final String QUERY_UPDATE = "UPDATE training SET nameTraining=?, idGroup=?, idStudent=? WHERE id=?";
	private final String QUERY_DELETE = "DELETE FROM training WHERE id=?;";
	
	public TrainingDAO() {
		
	}
	
	public List<Training> getAll(){
		List<Training> trainingList = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY_ALL);
			Training training;
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String nameTraining = resultSet.getString("nameTraining");
				int idGroup = resultSet.getInt("idGroup");
				int idStudent = resultSet.getInt("idStudent");
				training = new Training(nameTraining, idGroup, idStudent);
				training.setId(id);
				trainingList.add(training);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return trainingList;
	}
	
	public boolean insert(Training trainingToInsert) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_CREATE);
			preparedStatement.setString(1, trainingToInsert.getNameTraining());
			preparedStatement.setInt(2, trainingToInsert.getIdGroup());
			preparedStatement.setInt(3, trainingToInsert.getIdStudent());
			return true;
		} catch (SQLException e) {
			return false;
		}
	}
	
	public Training read(int trainingId) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
			preparedStatement.setInt(1, trainingId);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			String nameTraining;
			int idGroup, idStudent;
			nameTraining = resultSet.getString("nameTraining");
			idGroup = resultSet.getInt("idGroup");
			idStudent = resultSet.getInt("idStudent");
			Training training = new Training(nameTraining, idGroup, idStudent);
			training.setId(resultSet.getInt("id"));
			return training;			
		} catch (SQLException e) {
			return null;
		}
		
	}
	
	public boolean update(Training trainingToUpdate) {
		Connection connection = ConnectionSingleton.getInstance();
		//Check id
		if (trainingToUpdate.getId() == 0)
			return false;
			
			Training trainingRead = read(trainingToUpdate.getId());
			if(!trainingRead.equals(trainingToUpdate)) {
				try {
					if(trainingToUpdate.getNameTraining() == null || trainingToUpdate.getNameTraining().equals("")) {
						trainingToUpdate.setNameTraining(trainingRead.getNameTraining());
					}
					
					if(trainingToUpdate.getIdGroup() == 0) {
						trainingToUpdate.setIdGroup(trainingRead.getIdGroup());
					}
					
					if(trainingToUpdate.getIdStudent() == 0) {
						trainingToUpdate.setIdStudent(trainingRead.getIdStudent());
					}
					
					//Update Training
					PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE);
					preparedStatement.setString(1, trainingToUpdate.getNameTraining());
					preparedStatement.setInt(2, trainingToUpdate.getIdGroup());
					preparedStatement.setInt(3, trainingToUpdate.getIdStudent());
					int a = preparedStatement.executeUpdate();
					if(a > 0)
						return true;
					else
						return false;
					
				} catch (SQLException e) {
					return false;
				}
			}
			
			return false;
	}
	
	public boolean delete (int id) {
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
