package it.contrader.view.student;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class StudentDeleteView extends AbstractView {
	private Request request;
	
	private int id;
	private final String mode = "DELETE";
	
	public StudentDeleteView() {
	}
	public void showResults (Request request) {
		if (request!=null) {
			System.out.println("Cancellazione andata a buon fine.\n");
			MainDispatcher.getInstance().callView("Student", null);
			
		}
	}
	public void showOptions () {
		System.out.println("Inserisci id dello studente:");
		id = Integer.parseInt(getInput());
	}
	public void submit() {
		request= new Request();
		request.put("id", id);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Student", "doControl", request);
	}

}
