package it.contrader.view.group;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.model.Group;
import it.contrader.view.AbstractView;

public class GroupReadView extends AbstractView {
	
	private int id;
	private Request request;
	private final String mode = "READ";

	public GroupReadView() {
	}

	/**
	 * Se la request è null (ovvero quando arriva dal controller con mode GETCHOICE e choice L 
	 * il metodo è vuoto.
	 * 
	 * Altrimenti se arriva con uno user nella request (ovvero quando arriva
	 * dal controller con mode READ) mostra lo user. In questo caso torna alla UserView senza eseguire
	 * gli altri due metodi
	 */
	@Override
	public void showResults(Request request) {
		if (request != null) {
			Group group = (Group) request.get("group");
			System.out.println(group);
			MainDispatcher.getInstance().callView("Group", null);
		}
	}

	
	/**
	 * chiede all'utente di inserire l'id del gruppo da leggere
	 */
	@Override
	public void showOptions() {
		System.out.println("Inserisci l'ID del gruppo:");
		id = Integer.parseInt(getInput());
	}

	/**
	 * impacchetta una request con l'id dell'utente da leggere e la manda al controller tramite il Dispatcher
	 */
	@Override
	public void submit() {
		request = new Request();
		request.put("id", id);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Group", "doControl", request);
	}

}
