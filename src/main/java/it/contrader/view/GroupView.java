package it.contrader.view;

import java.util.List;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.model.Group;

public class GroupView extends AbstractView {
	private Request request;
	private String choice;
	
	public GroupView() {
		
	}
	
	public void showResults (Request request) {
		if (request!=null) {
			System.out.println ("\n------------------- Gestione utenti ----------------\n");
			System.out.println("ID\tidStudent");
			System.out.println("----------------------------------------------------\n");
			
			List<Group> group=(List<Group>) request.get("group");
			for(Group g:group)
				System.out.println(g);
			System.out.println();
		}
	}
	
	public void showOptions() {
		System.out.println("          Scegli l'operazione da effettuare:");
		System.out.println("[L]eggi [I]nserisci [M]odifica [C]ancella [B]ack [E]sci");

		this.choice = getInput();

	}
	public void submit() {
		request = new Request();
		request.put("choice", choice);
		request.put("mode", "GETCHOICE");
		MainDispatcher.getInstance().callAction("Grouè", "doControl", this.request);
	}

}
