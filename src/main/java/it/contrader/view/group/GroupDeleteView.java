package it.contrader.view.group;


import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;


public class GroupDeleteView extends AbstractView {
	
	private Request request;
	
	private int id;
	private final String mode = "DELETE";
	
	public GroupDeleteView() {
	}
	

	/**
	 * Se la request non è nulla (ovvero se si arriva dalla mode DELETE del controller) mostra
	 * l'esito dell'operazione
	 */
	@Override
	public void showResults(Request request) {
		if (request!=null) {
			System.out.println("Cancellazione andata a buon fine.\n");
			MainDispatcher.getInstance().callView("Group", null);
		}
	}

	/**
	 * Chiede all'utente di inserire l'id dell gruppo da cancellare
	 */
	@Override
	public void showOptions() {
			System.out.println("Inserisci id del gruppo:");
			id = Integer.parseInt(getInput());

	}

	/**
	 * impacchetta la request con l'id del gruppo da cancellare
	 */
	@Override
	public void submit() {
		request = new Request();
		request.put("id", id);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Group", "doControl", request);
	}


}
