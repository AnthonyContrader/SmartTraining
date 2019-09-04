package it.contrader.view.student;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class StudentInsertView extends AbstractView {
	private Request request;
	
	private String name;
	private String surname;
	private int idUser;
	private final String mode = "INSERT";
	
	public StudentInsertView() {
		
	}
	public void showResults (Request request) {
		if (request!=null) {
			System.out.println("Inserimento andato a buon fine.\n");
			MainDispatcher.getInstance().callView("Student", null);
		}
	}
	public void showOptions() {
		System.out.println("Insertisci Nome:");
		name=getInput();
		System.out.println("Inserisci Cognome:");
		surname=getInput();
		System.out.println("Inserisci idUser:");
		idUser=Integer.parseInt(getInput());
		
		
	}
	public void submit() {
		request=new Request();
		request.put("name", name);
		request.put("surname" , surname);
		request.put("idUser", idUser);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Student", "doControl" , request);
	}

}
