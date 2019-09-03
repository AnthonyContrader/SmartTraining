package it.contrader.service;

import java.util.List;

import it.contrader.dao.TrainingDAO;
import it.contrader.model.Training;

public class TrainingService {
	
	private TrainingDAO trainingDAO;
	
	public TrainingService( ) {
		this.trainingDAO = new TrainingDAO();
	}
	public List<Training> getAll(){
		return this.trainingDAO.getAll();
	}
	public Training read (int id) {
		return this.trainingDAO.read(id);
	}
	public boolean delete (int trainingId ) {
		return trainingDAO.delete(trainingId);
	}
	public boolean insert (Training training ) {
		return trainingDAO.insert(training);
	}
	public boolean update (Training training) {
		return trainingDAO.update(training);
	}
}
