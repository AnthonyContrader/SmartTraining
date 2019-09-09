package it.contrader.service;

import it.contrader.converter.ContentConverter;
import it.contrader.dao.ContentDAO;
import it.contrader.dto.ContentDTO;
import it.contrader.model.Content;

public class ContentService extends AbstractService<Content, ContentDTO> {
	
	public ContentService() {
		this.dao = new ContentDAO();
		this.converter = new ContentConverter();
	}

}
