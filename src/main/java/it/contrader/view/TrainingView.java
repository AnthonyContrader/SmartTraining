package it.contrader.view;

import java.util.List;

import java.util.List;
import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.model.Training;
import it.contrader.model.User;

public class TrainingView extends AbstractView {
	
	private Request request;
	private String choice;
	
	public TrainingView() {
		
	}
	
	@Override
	public void showResults(Request request) {
		if (request != null) {
			System.out.println("\n------------------- Gestione trainings ----------------\n");
			System.out.println("NameTraining\tidGroup\tidStudent\tid");
			System.out.println("----------------------------------------------------\n");
			
			@SuppressWarnings("unchecked")
			List<Training> trainings = (List<Training>) request.get("trainings");
			for (Training t: trainings)
				System.out.println(t);
			System.out.println();
		}
	}
	@Override
	public void showOptions() {
		System.out.println("          Scegli l'operazione da effettuare:");
		System.out.println("[L]eggi [I]nserisci [M]odifica [C]ancella [B]ack [E]sci");

		this.choice = getInput();
	}
	@Override
	public void submit() {
		request = new Request();
		request.put("choice", choice);
		request.put("mode", "GETCHOICE");
		MainDispatcher.getInstance().callAction("Training", "doControl", this.request);
	}

}
