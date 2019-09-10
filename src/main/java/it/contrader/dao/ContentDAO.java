package it.contrader.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import it.contrader.model.Content;
import it.contrader.utils.ConnectionSingleton;

public class ContentDAO  implements DAO<Content>{
	private final String QUERY_ALL = "SELECT * FROM content";
	private final String QUERY_CREATE = "INSERT INTO content (tag, title, text, idStudent) VALUES (?,?,?,?)";
	private final String QUERY_READ = "SELECT * FROM content WHERE id=?";
	private final String QUERY_UPDATE = "UPDATE content SET tag=?, title=?, text=?, idStudent=? WHERE id=?";
	private final String QUERY_DELETE = "DELETE FROM content WHERE id=?";

	public ContentDAO() {
	}
	@Override
	public List<Content> getAll() {
		// TODO Auto-generated method stub
		List <Content> contentsList = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY_ALL);
			Content content;
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String tag = resultSet.getString("tag");
				String title = resultSet.getString("title");
				String text = resultSet.getString("text");
				int idStudent = resultSet.getInt("idStudent");
				content = new Content(tag, title, text, idStudent);
				content.setId(id);
				contentsList.add(content);
			}
		}catch (SQLException e){
			e.printStackTrace();
		}
		return contentsList;
	}
	
	public boolean insert(Content contentToInsert) {
		Connection connection = ConnectionSingleton.getInstance();
		try {	
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_CREATE);
			preparedStatement.setString(1, contentToInsert.getTag());
			preparedStatement.setString(2, contentToInsert.getTitle());
			preparedStatement.setString(3, contentToInsert.getText());
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
			String tag, title, text;
			int idStudent;

			tag = resultSet.getString("tag");
			title = resultSet.getString("title");
			text = resultSet.getString("text");
			idStudent = resultSet.getInt("idStudent");
			Content content = new Content(tag, title, text, idStudent);
			content.setId(resultSet.getInt("id"));

			return content;
		} catch (SQLException e) {
			return null;
		}

	}

	public boolean update(Content contentToUpdate) {
		Connection connection = ConnectionSingleton.getInstance();
		
		if(contentToUpdate.getId() == 0) {
			return false;
		}
		
		Content contentRead = read(contentToUpdate.getId());
		if (!contentRead.equals(contentToUpdate)) {
			try {
				// Fill the userToUpdate object
				if (contentToUpdate.getTag() == null || contentToUpdate.getTag().equals("")) {
					contentToUpdate.setTag(contentRead.getTag());
				}

				if (contentToUpdate.getTitle() == null || contentToUpdate.getTitle().equals("")) {
					contentToUpdate.setTitle(contentRead.getTitle());
				}

				if (contentToUpdate.getText() == null || contentToUpdate.getText().equals("")) {
					contentToUpdate.setText(contentRead.getText());
				}
				if (contentToUpdate.getIdStudent() == 0) {
					contentToUpdate.setIdStudent(contentRead.getIdStudent());
				}

				PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE);
				preparedStatement.setString(1, contentToUpdate.getTag());
				preparedStatement.setString(2, contentToUpdate.getTitle());
				preparedStatement.setString(3, contentToUpdate.getText());
				preparedStatement.setInt(4, contentToUpdate.getIdStudent());
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
