package it.contrader.view.content;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class ContentInsertView extends AbstractView{
	private Request request;
	
	private String tag;
	private String title;
	private String text;
	private int idStudent;
	private int id;
	private final String mode = "INSERT";
	
	public ContentInsertView() {
		
	}

	@Override
	public void showResults(Request request) {
		// TODO Auto-generated method stub
		if(request != null) {
		System.out.println("Inserimento andato a buon fine.\n");
		MainDispatcher.getInstance().callView("Content", null);
		}
	}

	@Override
	public void showOptions() {
		// TODO Auto-generated method stub
		System.out.println("Inserisci tag:");
		tag = getInput();
		System.out.println("Inserisci il titolo:");
		title = getInput();
		System.out.println("Inserisci testo:");
		text = getInput();
		System.out.println("Inserisci idStudent:");
		idStudent = Integer.parseInt(getInput());
		System.out.println("Inserisci il tuo id:");
		id = Integer.parseInt(getInput());
		
	}

	@Override
	public void submit() {
		// TODO Auto-generated method stub
		request = new Request();
		request.put("tag", tag);
		request.put("titolo", title);
		request.put("testo", text);
		request.put("idStudent", idStudent);
		request.put("id", id);
		MainDispatcher.getInstance().callAction("Student", "doControl", request);
		
	}
	

}
