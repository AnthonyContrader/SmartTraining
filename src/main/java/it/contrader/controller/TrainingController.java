package it.contrader.controller;

import java.util.List;

import it.contrader.main.MainDispatcher;
import it.contrader.model.Training;
import it.contrader.service.TrainingService;

public class TrainingController implements Controller {
	private static String sub_package = "training.";
	
	private TrainingService trainingService;
	
	public TrainingController() {
		this.trainingService = new TrainingService();
	}
	
	@Override
	public void doControl(Request request) {
		//Estrae mode choice
		String mode = (String) request.get("mode");
		String choice = (String) request.get("choice");
		
		int id;
		String nameTraining;
		int idGroup, idStudent;
		
		switch (mode) {
		
		case "READ":
			id=Integer.parseInt(request.get("id").toString());
			Training training = trainingService.read(id);
			request.put("training", training);
			MainDispatcher.getInstance().callView(sub_package + "TrainingRead", request);
			break;
		
		case "INSERT":
			nameTraining = request.get("nameTraining").toString();
			idGroup = Integer.parseInt(request.get("idGroup").toString());
			idStudent = Integer.parseInt(request.get("idStudent").toString());
			//oggetto da inserire
			Training trainingToInsert = new Training(nameTraining, idGroup, idStudent);
			//invoca il service
			trainingService.insert(trainingToInsert);
			request = new Request();
			request.put("mode", "mode");
			MainDispatcher.getInstance().callView(sub_package + "TrainingInsert", request);
			break;
			
		case "DELETE":
			id= Integer.parseInt(request.get("id").toString());
			trainingService.delete(id);
			request = new Request();
			MainDispatcher.getInstance().callView(sub_package + "TrainingDelete", request);
			break;
			
		case "UPDATE":
			id = Integer.parseInt(request.get("id").toString());
			nameTraining = request.get("nameTraining").toString();
			idGroup = Integer.parseInt(request.get("idGroup").toString());
			idStudent = Integer.parseInt(request.get("idStudent").toString());
			Training trainingToUpdate = new Training(nameTraining, idGroup, idStudent);
			trainingToUpdate.setId(id);
			trainingService.update(trainingToUpdate);
			request = new Request();
			request.put("mode", "mode");
			MainDispatcher.getInstance().callView(sub_package + "TrainingToUpdate" , request);
			break;
			
		case "TRAININGLIST":
			List<Training> trainings = trainingService.getAll();
			request.put("trainings", trainings);
			MainDispatcher.getInstance().callView("Trainig", request);
			break;
			
		case "GETCHOICE":
			switch(choice.toUpperCase()) {
			
			case "L":
				MainDispatcher.getInstance().callView(sub_package + "TrainingRead", null);
				break;
			case "I":
				MainDispatcher.getInstance().callView(sub_package + "TrainingInsert", null);
				break;
			
			case "M":
				MainDispatcher.getInstance().callView(sub_package + "TrainingUpdate", null);
				break;
				
			case "C":
				MainDispatcher.getInstance().callView(sub_package + "TrainingDelete", null);
				break;
				
			case "E":
				MainDispatcher.getInstance().callView("Login", null);
				break;
				
			case "B":
				MainDispatcher.getInstance().callView("HomeAdmin", null);
				break;
				
			default:
				MainDispatcher.getInstance().callView("Login", null);
			}
			
		default:
			MainDispatcher.getInstance().callView("Login", null);
			
		}
	}

}
