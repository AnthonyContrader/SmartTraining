package it.contrader.view.training;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class TrainigUpdateView extends AbstractView {
	private Request request;
	
	private int id;
	private String nameTraining;
	private int idGroup;
	private int idStudent;
	private final String mode = "UPDATE";
	
	public void TrainingUpdateView() {
		
	}
	
	/**
	 * Se la request non è nulla (ovvero se si arriva dalla mode UPDATE del controller) mostra
	 * l'esito dell'operazione
	 */
	@Override
	public void showResults(Request request) {
		if (request!=null) {
			System.out.println("Modifica andata a buon fine.\n");
			MainDispatcher.getInstance().callView("User", null);
		}
	}
	
	/**
	 * Chiede all'utente di inserire gli attributi dell'utente da modificare
	 */
	@Override
	public void showOptions() {
		try {
			System.out.println("Inserisci id del Trainig:");
			id = Integer.parseInt(getInput());
			System.out.println("Inserisci nome del Training:");
			nameTraining = toString();
			System.out.println("Inserisci id del Gruppo:");
			idGroup = Integer.parseInt(getInput());
			System.out.println("Inserisci id dello Studente:");
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
		request.put("NameTraining", nameTraining);
		request.put("idGroup", idGroup);
		request.put("idStudent", idStudent);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("User", "doControl", request);
		
	}
}
