package it.contrader.view.group;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class GroupUpdateView extends AbstractView {
	
	private Request request;

	private int id;
	private int idStudent;
	
	private final String mode = "UPDATE";

	public GroupUpdateView() {
	}

	/**
	 * Se la request non è nulla (ovvero se si arriva dalla mode UPDATE del controller) mostra
	 * l'esito dell'operazione
	 */
	@Override
	public void showResults(Request request) {
		if (request!=null) {
			System.out.println("Modifica andata a buon fine.\n");
			MainDispatcher.getInstance().callView("Group", null);
		}
	}

	/**
	 * Chiede all'utente di inserire gli attributi dell'utente da modificare
	 */
	@Override
	public void showOptions() {
		try {
			System.out.println("Inserisci id del Group:");
			id = Integer.parseInt(getInput());
			System.out.println("Inserisci Id studente:");
			idStudent = Integer.parseInt(getInput());
			
		} catch (Exception e) {

		}
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
