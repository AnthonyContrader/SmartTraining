package it.contrader.view.training;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class TrainingInsertView extends AbstractView{
	private Request request;
	
	private String nameTraining;
	private int idGroup;
	private int idStudent;
	private final String mode = "INSERT";
	
	public TrainingInsertView() {
		
	}

	@Override
	public void showResults(Request request) {
		// TODO Auto-generated method stub
		if(request!=null) {
			System.out.println("Inserimento andato a buon fine.\n");
			MainDispatcher.getInstance().callView("User", null);
		}
		
	}

	@Override
	public void showOptions() {
		// TODO Auto-generated method stub
		System.out.println("Inserisci nome training");
		nameTraining = getInput();
		
	}

	@Override
	public void submit() {
		// TODO Auto-generated method stub
		request = new Request();
		request.put("nameTraining", nameTraining);
		MainDispatcher.getInstance().callAction("Training", "doControl", request);
		
	}

}
