package it.contrader.service;

import it.contrader.converter.TrainingConverter;
import it.contrader.dao.TrainingDAO;
import it.contrader.dto.TrainingDTO;
import it.contrader.model.Training;

public class TrainingService extends AbstractiveSrrvice<training, TrainingDTO> {
	
	public TrainingService() {
		this.dao = new TrainingDAO();
		this.converter = new TrainingConverter();
	}

}
