package it.contrader.service;

import java.util.List;

public class ContentService {
	
	private ContentDAO contentDAO;
	
	public ContentService() {
		this.contentDAO = new ContentDAO();
	}
	public List<Content> getAll() {
		return this.contentDAO.getAll();
	}
	public Content read (int id) {
		return this.contentDAO.read(id);
	}
	public boolean delete (int contentId) {
		return contentDAO.delete(contentId);
	}
	public boolean insert (Content content) {
		return contentDAO.insert(content);
	}
	public boolean update (Content content) {
		return contentDAO.update (content);
	}

}
