<<<<<<< HEAD
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
			MainDispatcher.getInstance().callView("Training", null);
		}
		
	}

	@Override
	public void showOptions() {
		// TODO Auto-generated method stub
		System.out.println("Inserisci nome training");
		nameTraining = getInput();
		System.out.println("Inserisci id del gruppo");
		idGroup = Integer.parseInt(getInput());
		System.out.println("Inserisci id dello studente");
		idStudent = Integer.parseInt(getInput());
		
	}

	@Override
	public void submit() {
		// TODO Auto-generated method stub
		request = new Request();
		request.put("nameTraining", nameTraining);
		request.put("idGroup", idGroup);
		request.put("idStudent", idStudent);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Training", "doControl", request);
		
	}

}
=======
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
		System.out.println("Inserisci id del gruppo");
		idGroup = Integer.parseInt(getInput());
		System.out.println("Inserisci id dello studente");
		idStudent = Integer.parseInt(getInput());
		
	}

	@Override
	public void submit() {
		// TODO Auto-generated method stub
		request = new Request();
		request.put("nameTraining", nameTraining);
		request.put("idGroup", idGroup);
		request.put("idStudent", idStudent);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Training", "doControl", request);
		
	}

}
>>>>>>> 465011633f9dbbbd733b2e69b501b4530a2d0770
