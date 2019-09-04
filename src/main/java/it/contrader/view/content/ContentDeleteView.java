package it.contrader.view.content;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class ContentDeleteView  extends AbstractView{
	private Request request;
	
	private int id;
	private final String mode = "DELETE";
	
	public ContentDeleteView() {
	}

	@Override
	public void showResults(Request request) {
		// TODO Auto-generated method stub
		if (request != null) {
			System.out.println("Cancellazione andata a buon fine.\n");
			MainDispatcher.getInstance().callView("Content", null);
		}
	}

	@Override
	public void showOptions() {
		// TODO Auto-generated method stub
		System.out.println("Inserisci id del contenuto:");
		id = Integer.parseInt(getInput());
	}

	@Override
	public void submit() {
		// TODO Auto-generated method stub
		request = new Request();
		request.put("id", id);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Content", "doControl", request);
		
	}
}