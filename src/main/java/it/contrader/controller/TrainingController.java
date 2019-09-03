package it.contrader.controller;

import it.contrader.main.MainDispatcher;

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
		}
	}

}
