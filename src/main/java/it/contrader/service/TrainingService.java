package it.contrader.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.contrader.converter.TrainingConverter;
import it.contrader.dao.TrainingRepository;
import it.contrader.dto.TrainingDTO;
import it.contrader.model.Training;

@Service
public class TrainingService extends AbstractService<Training,TrainingDTO> {
	
	@Autowired
	private TrainingConverter converter;
	@Autowired
	private TrainingRepository repository;
	
	public TrainingDTO findJobById(long id) {
		return converter.toDTO(repository.findTrainingById(id));
	}

}
