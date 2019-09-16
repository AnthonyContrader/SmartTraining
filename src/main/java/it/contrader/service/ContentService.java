package it.contrader.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import it.contrader.converter.ContentConverter;
import it.contrader.dao.ContentRepository;
import it.contrader.dto.ContentDTO;
import it.contrader.model.Content;

@Service
public class ContentService extends AbstractService<Content, ContentDTO> {

	@Autowired
	private ContentConverter converter;
	@Autowired
	private ContentRepository repository;

	public ContentDTO findContentById(long id) {
		return converter.toDTO(repository.findContentById(id));
	}

}
