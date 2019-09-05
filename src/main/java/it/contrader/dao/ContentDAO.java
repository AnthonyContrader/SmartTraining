package it.contrader.dao;

import java.sql.*;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import it.contrader.main.ConnectionSingleton;
import it.contrader.model.Content;

import it.contrader.main.ConnectionSingleton;
import it.contrader.model.Content;

public class ContentDAO {
	
	private final String QUERY_ALL = "SELECT * FROM content";
	private final String QUERY_CREATE = "INSERT INTO content (titel, text, tag, idStudent) VALUES (?,?,?,?)";
	private final String QUERY_READ = "SELECT * from content WHERE id=?";
	private final String QUERY_UPDATE = "UPDATE content SET title=?, text=?, tag=?, idStudent=? WHERE id=?";
	private final String QUERY_DELETE = "DELETE FROM content WHERE id=?";
	
	public ContentDAO() {
		
	}
	
	public List<Content> getALL() {
		List<Content> contentsList = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY_ALL);
			Content contents;
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String title = resultSet.getString("title");
				String text = resultSet.getString("text");
				String tag = resultSet.getString("tag");
				int idStudent = resultSet.getInt("idStudent");
				contents = new Content( title, text, tag, idStudent);
				contents.setid(id);
				contentsList.add(contents);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return contentsList;
	}
	
	public boolean insert(Content contentToInsert) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_CREATE);
			preparedStatement.setString(1, contentToInsert.getTitle());
			preparedStatement.setString(2, contentToInsert.getText());
			preparedStatement.setString(3, contentToInsert.getTag());
			preparedStatement.setInt(4, contentToInsert.getIdStudent());
			preparedStatement.execute();
			return true;
		} catch (SQLException e) {
			return false;
		}
	}
	
	public Content read(int contentId) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			
			
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
			preparedStatement.setInt(1, contentId);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			String title, text, tag;
			int idStudent;
			
			title = resultSet.getString("title");
			text = resultSet.getString("text");
			tag = resultSet.getString("tag");
			idStudent = resultSet.getInt("idStudent");
			Content content = new Content(title, tag, text, idStudent);
			content.setid(resultSet.getInt("id"));
			
			return content;
		} catch (SQLException e) {
			return null;
		}
	}
	
	public boolean update (Content contentToUpdate) {
		Connection connection = ConnectionSingleton.getInstance();
		
		//Check if id is present
		if (contentToUpdate.getid() == 0)
			return false;
		
		Content contentRead = read(contentToUpdate.getid());
		if (!contentRead.equals(contentToUpdate)) {
			try {
				//Final the contentToUpdate object
				if (contentToUpdate.getTitle() == null || contentToUpdate.getTitle().equals("")) {
					contentToUpdate.setTitle(contentRead.getTitle());
				}
				
				if (contentToUpdate.getText() == null || contentToUpdate.getText().equals("")) {
					contentToUpdate.setText(contentRead.getText());
				}
				
				if (contentToUpdate.getTag() == null || contentToUpdate.getTag().equals("")) {
					contentToUpdate.setTag(contentRead.getTag());
				}
				
				if (contentToUpdate.getIdStudent() == 0 || contentToUpdate.getIdStudent() == 0) {
					contentToUpdate.setIdStudent(contentRead.getIdStudent());
				}
				
				// Update the content
				
				PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE);
				preparedStatement.setString(1, contentToUpdate.getTitle());
				preparedStatement.setString(2, contentToUpdate.getTag());
				preparedStatement.setString(3, contentToUpdate.getText());
				preparedStatement.setInt(4, contentToUpdate.getIdStudent());
				preparedStatement.setInt(5, contentToUpdate.getid());
				int a = preparedStatement.executeUpdate();
				if (a > 0)
					return false;
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
