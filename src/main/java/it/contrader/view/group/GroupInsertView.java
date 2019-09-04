package it.contrader.view.group;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class GroupInsertView extends AbstractView{
	private Request request;

	private int id;
	private int idStudent;
	private final String mode = "INSERT";

	public GroupInsertView() {
	}
	
	/**
	 * Se la request non è nulla (ovvero se si arriva dalla mode INSERT del controller) mostra
	 * l'esito dell'operazione
	 */
	@Override
	public void showResults(Request request) {
		if (request!=null) {
			System.out.println("Inserimento andato a buon fine.\n");
			MainDispatcher.getInstance().callView("Group", null);
		}
	}

	/**
	 * Chiede all'utente di inserire gli attributi del gruppo da inserire
	 */
	@Override
	public void showOptions() {
			System.out.println("Inserisci id del gruppo:");
			id = Integer.parseInt(getInput());
			System.out.println("Inserisci id dello studente:");
			idStudent = Integer.parseInt(getInput());		 
	}

	/**
	 * Impacchetta la request con i dati inseriti nel metodo showOption()
	 */
	@Override
	public void submit() {
		request = new Request();
		request.put("id", id);
		request.put("idStudent", idStudent);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Group", "doControl", request);
	}
}

