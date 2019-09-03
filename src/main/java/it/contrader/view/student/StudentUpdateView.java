package it.contrader.view.student;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class StudentUpdateView extends AbstractView {
	private Request request;
	
	private int id;
	private String name;
	private String surname;
	private int idUser;
	private final String mode="UPDATE";
	
	public StudentUpdateView() {
		
	}
	public void showResults( Request request) {
		if (request!=null) {
			System.out.println("Modifica andata a buon fine");
			MainDispatcher.getInstance().callView("Student", null);
			
		}
	}
	public void showOptions() {
		try {
			System.out.println("Inserisci id dell'utente:");
			id = Integer.parseInt(getInput());
			System.out.println("Inserisci il nome:");
			name=getInput();
			System.out.println("Inserisci il cognome:");
			surname=getInput();
			System.out.println("Inserisci il idUser:");
			idUser=Integer.parseInt(getInput());
					
				
			} catch (Exception e) {
				
			}
			
		}
		public void submit() {
			request = new Request();
			request.put("id", id);
			request.put("Name", name);
			request.put("surname", surname);
			request.put("idUser", idUser);
			request.put("mode", mode);
			MainDispatcher.getInstance().callAction("Student", "doControl", request);
	}

}
