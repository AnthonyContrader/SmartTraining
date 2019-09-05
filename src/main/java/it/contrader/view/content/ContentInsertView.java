package it.contrader.view.content;


import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class ContentInsertView extends AbstractView{
	private Request request;

	private String title,text,tag;
	private int idStudent;
	private final String mode = "INSERT";

	public ContentInsertView() {
	}
	
	/**
	 * Se la request non è nulla (ovvero se si arriva dalla mode INSERT del controller) mostra
	 * l'esito dell'operazione
	 */
	@Override
	public void showResults(Request request) {
		if (request!=null) {
			System.out.println("Inserimento andato a buon fine.\n");
			MainDispatcher.getInstance().callView("Content", null);
		}
	}

	/**
	 * Chiede all'utente di inserire gli attributi del gruppo da inserire
	 */
	@Override
	public void showOptions() {
		System.out.println("Inserisci il titolo:");
		title = getInput();
		System.out.println("Inserisci il testo:");
		text =getInput();
		System.out.println("Inserisci il tag:");
		tag =getInput();
		System.out.println("Inserisci id dello studente:");
		idStudent = Integer.parseInt(getInput());	 
	}

	/**
	 * Impacchetta la request con i dati inseriti nel metodo showOption()
	 */
	@Override
	public void submit() {
		request = new Request();
		request.put("title", title);
		request.put("text", text);
		request.put("tag", tag);
		request.put("idStudent", idStudent);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Content", "doControl", request);
	}
}

