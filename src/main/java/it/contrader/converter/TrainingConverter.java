package it.contrader.converter;

import org.springframework.stereotype.Component;

import it.contrader.dto.TrainingDTO;
import it.contrader.model.Training;

@Component
public class TrainingConverter  extends AbstractConverter <Training, TrainingDTO> {
	
	@Override
	public Training toEntity (TrainingDTO trainingDTO) {
		Training training = null;
		if (trainingDTO!= null) {
			training = new Training (trainingDTO.getId(), trainingDTO.getNameTraining(), trainingDTO.getIdGruppo());
			
		}
		return training;
	}
	
	@Override
	public TrainingDTO toDTO (Training training) {
		TrainingDTO trainingDTO=null;
		if (training != null) {
			trainingDTO = new TrainingDTO (training.getId(), training.getNameTraining(), training.getIdGruppo());
			
		}
		return trainingDTO;
	}

}
