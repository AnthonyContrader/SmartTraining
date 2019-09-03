package it.contrader.view.content;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class ContentDeleteView  extends AbstractView{
	private Request request;
	
	private int id;
	private final String mode = "DELETE";
	
	public ContentDeleteView() {
		
		
		
		public void showResults(Request request) {
			if (request != null) {
				System.out.println("Cancellazione andata a buon fine.\n");
				MainDispatcher.getInstance().callView("Content", null);
			}
		}
		
		public void showOption() {
			System.out.println("Inserisci id dell'utente:");
		}
	}
}
