package it.contrader.controller;

import java.util.List;

import it.contrader.main.MainDispatcher;
import it.contrader.model.Group;
import it.contrader.service.GroupService;

public class GroupController implements Controller {
	
	/**
	 * definisce il pacchetto di vista group.
	 */
	private static String sub_package = "group.";
	
	private GroupService groupService;
	/**
	 * Costruisce un oggetto di tipo GroupService per poterne usare i metodi
	 */
	public GroupController() {
		this.groupService = new GroupService();
	}
	
	
	
	/**
	 * Metodo dell'interfaccia Controller. Estrae dalla request la mode
	 * (che riceve dalle view specifiche e può essere la richesta di una 
	 * scelta da parte dell'utente "GETCHOICE") e la scelta dell'utente.
	 * 
	 * Se la modalità corrisponde ad una CRUD il controller chiama i service,
	 * altrimenti rimanda alla View della CRUD per richiedere i parametri
	 */
	@Override
	public void doControl(Request request) {
		
		//Estrae dalla request mode e choice
		String mode = (String) request.get("mode");
		
		String choice = (String) request.get("choice");

		//Definisce i campi della classe (serviranno sempre, tanto vale definirli una sola volta)
		int id;
		int idStudent;
		
		switch (mode) {
		
		// Arriva qui dalla UserReadView. Invoca il Service con il parametro id e invia alla UserReadView uno user da mostrare 
		case "READ":
			id = Integer.parseInt(request.get("id").toString());
			Group group = groupService.read(id);
			request.put("group", group);
			MainDispatcher.getInstance().callView(sub_package + "GroupRead", request);
			break;
			
		case "INSERT":
			id = Integer.parseInt(request.get("id").toString());
			idStudent = Integer.parseInt(request.get("idStudent").toString());
			Group groupToInsert = new Group(id, idStudent);
			groupService.insert(groupToInsert);
			request = new Request();
			request.put("mode", "mode");
			MainDispatcher.getInstance().callView(sub_package + "GroupInsert", request);
			break;
			
		case "DELETE":
			id = Integer.parseInt(request.get("id").toString());
			groupService.delete(id);
			request = new Request();
			request.put("mode", "mode");
			MainDispatcher.getInstance().callView(sub_package + "GroupDelete", request);
			break;
			
		case "UPDATE":
			id = Integer.parseInt(request.get("id").toString());
			idStudent = Integer.parseInt(request.get("idStudent").toString());
			Group groupToUpdate = new Group(id, idStudent);
			groupToUpdate.setId(id);
			groupService.update(groupToUpdate);
			request = new Request();
			request.put("mode", "mode");
			MainDispatcher.getInstance().callView(sub_package + "GroupUpdate", request);
			break;
			
		//Arriva qui dalla GroupView Invoca il Service e invia alla GroupView il risultato da mostrare 
		case "GROUPLIST":
			List<Group> groups = groupService.getAll();
			//Impacchetta la request con la lista degi user
			request.put("groups", groups);
			MainDispatcher.getInstance().callView("Group", request);
			break;
			
		//Esegue uno switch sulla base del comando inserito dall'utente e reindirizza tramite il Dispatcher alla View specifica per ogni operazione
		//con REQUEST NULL (vedi una View specifica)
		case "GETCHOICE":
					
					//toUpperCase() mette in maiuscolo la scelta
			switch (choice.toUpperCase()) {
			
			case "L":
				MainDispatcher.getInstance().callView(sub_package + "GroupRead", null);
				break;
				
			case "I":
				MainDispatcher.getInstance().callView(sub_package + "GroupInsert", null);
				break;
				
			case "M":
				MainDispatcher.getInstance().callView(sub_package + "GroupUpdate", null);
				break;
				
			case "C":
				MainDispatcher.getInstance().callView(sub_package + "GroupDelete", null);
				
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
			MainDispatcher.getInstance().callView("Login", null);
		}
	}

}
