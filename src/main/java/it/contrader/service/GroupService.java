package it.contrader.service;

import java.util.List;

import it.contrader.dao.GroupDAO;
import it.contrader.model.Group;

public class GroupService {
	
	private GroupDAO groupDAO;
	/**
	 * Costruisce un oggetto di tipo GroupDAO per poterne usare i metodi
	 */
	public GroupService() {
		this.groupDAO = new GroupDAO();
	}

	//chiama il metodo del DAO che ottiene una lista di tutti gli Group
	public List<Group> getAll() {
		return this.groupDAO.getAll();
	}
	
	//chiama il metodo del DAO che restituisce un Group in base al suo id
	public Group read(int id) {
		return this.groupDAO.read(id);
	}

}