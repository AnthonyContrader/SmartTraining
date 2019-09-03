package it.contrader.view.training;

import it.contrader.main.MainDispatcher;

public class TraininigDeleteView extends AbstractView {
	private Request request;
	
	private int id;
	private final String mode = "DELETE";
	
	public UserDeleteView() {
		
	}
	
	/**
	 * Se la request non è nulla (ovvero se si arriva dalla mode DELETE del controller) mostra
	 * l'esito dell'operazione
	 */
	@Override
	public void showResults(Request request) {
		if (request != null) {
			System.out.println("Cancellazione andata a buon fine. \n");
			MainDispatcher.getInstance().callView(view, request);
		}
	}

}
