package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.TrainingDTO;
import it.contrader.dto.UserDTO;
import it.contrader.model.Training;
import it.contrader.model.User;

public class TrainingConverter implements Converter <Training, TrainingDTO>{
	
	@Override
	public TrainingDTO toDTO(Training training) {
		TrainingDTO trainingDTO = new TrainingDTO(training.getId(), training.getNameTraining(), training.getIdGroup(), training.getIdStudent());
		return trainingDTO;
	}

	@Override
	public Training toEntity(TrainingDTO trainingDTO) {
		Training training = new Training (trainingDTO.getId(), trainingDTO.getNameTraining(), trainingDTO.getIdGroup(), trainingDTO.getIdStudent());
		return training;
	}
	
	@Override
	public List<TrainingDTO> toDTOList(List<Training> trainingList) {
		
		List<TrainingDTO> trainingDTOList = new ArrayList<TrainingDTO>();
		
		for(Training training : trainingList) {
			
			trainingDTOList.add(toDTO(training));
		}
		return trainingDTOList;
	}

	
	
}

