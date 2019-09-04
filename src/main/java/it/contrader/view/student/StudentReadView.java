package it.contrader.view.student;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.model.Student;
import it.contrader.view.AbstractView;

public class StudentReadView extends AbstractView {
	private int id;
	private Request request;
	private final String mode="READ";
	
	public StudentReadView() {
	}
	public void showResults (Request request) {
		if (request!=null) {
			Student student =(Student) request.get("student");
			System.out.println(student);
			MainDispatcher.getInstance().callView("Student", null);
		}
	}
	public void showOptions() {
		System.out.println("Inseriscil'ID dell'utente:");
		id=Integer.parseInt(getInput());
	}
	public void submit() {
		request=new Request();
		request.put("id", id);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Student", "doControl", request);
	}
}
