package it.contrader.view;

import java.util.List;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.model.Student;
import it.contrader.model.User;

public class StudentView extends AbstractView {
	
	private Request request;
	private String choice;
	
	public StudentView() {
		
	}
	
	public void showResults(Request request) {
		if (request != null) {
			System.out.println("\n------------------- Gestione utenti ----------------\n");
			System.out.println("ID\tName\tSurname\tIdUser");
			System.out.println("----------------------------------------------------\n");
			
			List<Student> students = (List<Student>) request.get("students");
			for (Student s: students)
				System.out.println(s);
			System.out.println();
		}
	}
		
	public void showOptions() {
		System.out.println("          Scegli l'operazione da effettuare:");
		System.out.println("[L]eggi [I]nserisci [M]odifica [C]ancella [B]ack [E]sci");

		this.choice = getInput();
	}
		
	public void submit() {
		request = new Request();
		request.put("choice", choice);
		request.put("mode", "GETCHOICE");
		MainDispatcher.getInstance().callAction("Student", "doControl", this.request);
	}
}


