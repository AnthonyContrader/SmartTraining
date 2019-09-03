package it.contrader.service;

import java.util.List;

import it.contrader.dao.GroupDAO;
import it.contrader.model.Group;
import it.contrader.model.Group;

public class GroupService {
	
	private GroupDAO groupDAO;
	/**
	 * Costruisce un oggetto di tipo GroupDAO per poterne usare i metodi
	 */
	public GroupService() {
		this.groupDAO = new GroupDAO();
	}

	//chiama il metodo del DAO che ottiene una lista di tutti i Group
	public List<Group> getAll() {
		return this.groupDAO.getAll();
	}
	
	//chiama il metodo del DAO che restituisce un Group in base al suo id
	public Group read(int id) {
		return this.groupDAO.read(id);
	}
	
	//chiama il metodo del DAO che cancella uno Group in base al suo id
		public boolean delete(int groupId) {
			return groupDAO.delete(groupId);
		}
		
		//chiama il metodo del DAO che inserisce un oggetto Group
		public boolean insert(Group group) {
			return groupDAO.insert(group);
		}

		//chiama il metodo del DAO che modifica un utente
		public boolean update(Group group) {
			return groupDAO.update(group);
		}

}
