package it.contrader.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.contrader.dao.GruppoRepository;
import it.contrader.model.Gruppo;

@Service
public class GruppoService extends AbstractService<Gruppo, GruppoDTO>{
	@Autowired
	private GruppoConverter converter;
	
	@Autowired
	private GruppoRepository repository;
	
	public GroupDTO findById(Long id) {
		return converter.toDTO(repository.findGruppoById(id));
	}

}
