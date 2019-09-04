package it.contrader.view.training;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.model.Training;
import it.contrader.view.AbstractView;

public class TrainingReadView extends AbstractView{
	private int id;
	private Request request;
	private final String mode = "READ";
	
	public TrainingReadView() {
		
	}

	@Override
	public void showResults(Request request) {
		// TODO Auto-generated method stub
		if(request != null) {
			Training training = (Training) request.get("training");
			System.out.println(training);
			MainDispatcher.getInstance().callView("User", null);
		}
		
	}

	@Override
	public void showOptions() {
		// TODO Auto-generated method stub
		System.out.println("Inserisci l'ID del training:");
		id = Integer.parseInt(getInput());
		
	}

	@Override
	public void submit() {
		// TODO Auto-generated method stub
		request = new Request();
		request.put("id", id);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Training", "doControl", request);
		
	}

}
