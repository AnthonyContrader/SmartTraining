package it.contrader.view.content;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.model.Content;
import it.contrader.view.AbstractView;

public class ContentReadView extends AbstractView {
	
	private int id;
	private Request request;
	private final String mode = "READ";
	
	public  ContentReadView () {
	}
	
	@Override
	public void showResults(Request request) {
		if(request != null) {
			Content content = (Content) request.get("content");
			System.out.println(content);
			MainDispatcher.getInstance().callView("Content", null);
		}
	}
	
	@Override
	public void showOptions() {
		System.out.println("Inserisci l'ID del contenuto:");
		id = Integer.parseInt(getInput());
	}
	
	//private String getInput() {
		// TODO Auto-generated method stub
		//return null;
	//}

	@Override
	public void submit () {
		request = new Request();
		request.put("id", id);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Content", "doControl", request);
	}

}

