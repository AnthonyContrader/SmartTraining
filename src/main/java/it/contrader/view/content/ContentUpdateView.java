package it.contrader.view.content;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class ContentUpdateView extends AbstractView{


	private Request request;

	private int id;
	private String tag;
	private String title;
	private String text;
	private int idStudent;
	private final String mode = "UPDATE";

	public ContentUpdateView() {
	}

	
	@Override
	public void showResults(Request request) {
		if (request!=null) {
			System.out.println("Modifica andata a buon fine.\n");
			MainDispatcher.getInstance().callView("User", null);
		}
	}

	
	@Override
	public void showOptions() {
		try {
			System.out.println("Inserisci id dell'utente:");
			id = Integer.parseInt(getInput());
			System.out.println("Inserisci il tag:");
			tag = getInput();
			System.out.println("Inserisci il titolo:");
			title = getInput();
			System.out.println("Inserisci il testo:");
			text = getInput();
			System.out.println("Inserisci l'idStudent:");
			idStudent = Integer.parseInt(getInput());
		} catch (Exception e) {

		}
	}


	
	@Override
	public void submit() {
		request = new Request();
		request.put("id", id);
		request.put("tag", tag);
		request.put("title", title);
		request.put("text", text);
		request.put("idStudent", idStudent);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Content", "doControl", request);
	}
	
}
