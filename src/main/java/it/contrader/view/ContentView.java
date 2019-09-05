package it.contrader.view;

import java.util.List;
import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.model.Content;

public class ContentView extends AbstractView {
	
	private Request request;
	private String choice;
	
	public ContentView() {
		
	}
	
	@Override
	public void showResults(Request request) {
		if (request != null) {
			System.out.println("\n------------------- Gestione contenuti ----------------\n");
			System.out.println("ID\tTitle\tText\tTag\tidStudent");
			System.out.println("----------------------------------------------------\n");
			
			@SuppressWarnings("unchecked")
			List<Content> contents = (List<Content>) request.get("contents");
			for (Content c: contents)
				System.out.println(c);
			System.out.println();
		}
	}
	@Override
	public void showOptions() {
		System.out.println("          Scegli l'operazione da effettuare:");
		System.out.println("[L]eggi [I]nserisci [M]odifica [C]ancella [V]isualizza [B]ack [E]sci");

		this.choice = getInput();
	}
	@Override
	public void submit() {
		request = new Request();
		request.put("choice", choice);
		request.put("mode", "GETCHOICE");
		MainDispatcher.getInstance().callAction("Content", "doControl", this.request);
	}
}
