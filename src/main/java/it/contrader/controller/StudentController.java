package it.contrader.controller;

import it.contrader.main.MainDispatcher;
import it.contrader.model.Student;
import it.contrader.service.StudentService;

public class StudentController implements Controller{

	private static String sub_package = "user.";
	
	private StudentService studentService;
	
	public StudentController() {
		this.studentService = new StudentService();
	}
	
	public void doControl(Request request) {
		String mode = (String) request.get("mode");
		
		String choice = (String) request.get("choice");
		
		int id;
		String name;
		String surname;
		int idUser;
		
		switch (mode) {
		
		case "READ":
			id = Integer.parseInt(request.get("id").toString());
			Student student = studentService.read(id);
			request.put("student", studente);
			MainDispatcher.getInstance().callView(sub_package + "StudentRead", request);
			break;
		case "INSERT":
			name = request.get("name").toString();
			surname = request.get("surname").toString();
			idUser = Integer.parseInt(request.get("idUser").toString());
			
			Student studentinsert = new Student (name, surname, idUser);
			
		    studentService.insert(studentinsert);
		    request = new Request();
		    request.put("mode", "mode");
		    
		    MainDispatcher.getInstance().callView(sub_package + "StudentInsert", request);
		    break;
		    
		case "DELETE":
			id = Integer.parseInt(request.get("id").toString());
			
			studentService.delete(id);
			request = new Request();
			request.put("mode", "mode");
			MainDispatcher.getInstance().callView(sub_package + "StudentDelete", request);
			break;
			
		case "UPDATE":
			id = Integer.parseInt(request.get("id").toString());
			name = request.get("name").toString();
			surname = request.get("surname").toString();
			idUser = Integer.parseInt(request.get("idUser").toString());
			Student studentupdate = new Student(name, surname, idUser);
			studentupdate.setId(id);
			studentService.update(studentupdate);
			request = new Request();
			request.put("mode", "mode");
			MainDispatcher.getInstance().callView(sub_package + "StudentUpdate"_, request);
			break;
			
		case "USERLIST":
			List<Student> student = studentService.getAll();
			
			request.put("student", student);
			MainDispatcher.getInstance().callView("Student", request);
			break;
			
		case "GETCHOICE":
			
			switch (choice.ToUpperCase()) {
			
			case "L":
				MainDispatcher.getInstance().callView(sub_package + "StudentRead", null);
				break;
				
			case "I":
				MainDispatcher.getInstance().callView(sub_package + "StudentInsert", null);
				break;
				
			case "M":
				MainDispatcher.getInstance().callView(sub_package + "StudentUpdate", null);
				break;
				
			case "C":
				MainDispatcher.getInstance().callView(sub_package + "StudentDelete", null);
				break:
					
			case "E":
				MainDispatcher.getInstance().callView("Login", null);
				break;
			case "B":
				MainDispatcher.getInstance().callView("HomeAdmin", null);
				break;
			default:
				MainDispatcher.getInstance().callView("Login", null);
			}
			default:
				MainDispatcher.getInstance().callView("login", null);
			
		}
	}
}