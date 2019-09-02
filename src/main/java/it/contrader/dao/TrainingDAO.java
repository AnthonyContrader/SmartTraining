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
				trainingList.add(training)
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
			
		}
	}

}
