package it.contrader.service;

import it.contrader.converter.GroupConverter;
import it.contrader.dao.GroupDAO;
import it.contrader.dto.GroupDTO;
import it.contrader.model.Group;


public class GroupService extends AbstractService<Group, GroupDTO>  {
	
	public GroupService() {
		this.dao = new ContentDAO();
		this.converter = new ContentConverter();
	}

}
