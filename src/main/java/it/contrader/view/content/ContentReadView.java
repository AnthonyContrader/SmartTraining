package it.contrader.view.content;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.model.Content;

public class ContentReadView {
	
	private int id;
	private Request request;
	private final String mode = "READ";
	
	public  ContentReadView () {
	}
	
	public void showResult(Request request) {
		if(request != null) {
			Content content = (Content) request.get("content");
			System.out.println(content);
			MainDispatcher.getInstance().callView("Content", null);
		}
	}
	
	public void showOption() {
		System.out.println("Inserisci l'ID dell'utente:");
		id = Integer.parseInt(getInput());
	}
	
	private String getInput() {
		// TODO Auto-generated method stub
		return null;
	}

	public void submit () {
		request = new Request();
		request.put("id", id);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Content", "doControl", request);
	}

}

