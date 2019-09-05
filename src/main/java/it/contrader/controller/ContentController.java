package it.contrader.controller;

import java.util.List;

import it.contrader.main.MainDispatcher;
import it.contrader.model.Content;
import it.contrader.service.ContentService;

public class ContentController implements Controller {
	
	private static String sub_package = "content.";
	
	private ContentService contentService;
	
	public ContentController() {
		this.contentService = new ContentService();
	}
	
	@Override
	public void doControl(Request request) {
		//Estrae mode choice
		String mode = (String) request.get("mode");
		String choice = (String) request.get("choice");
		
		int id;
		String text;
		String title;
		String tag;
		int idStudent;
		
		switch (mode) {
		
		case "READ":
			id=Integer.parseInt(request.get("id").toString());
			Content content = contentService.read(id);
			request.put("content", content);
			MainDispatcher.getInstance().callView(sub_package + "ContentRead", request);
			break;
			
		case "INSERT":
			title = request.get("title").toString();
			text = request.get("text").toString();
			tag = request.get("tag").toString();
			idStudent = Integer.parseInt(request.get("idStudent").toString());
			
			Content contenttoinsert = new Content(title, text, tag, idStudent);
			contentService.insert(contenttoinsert);
			request = new Request();
			request.put("mode", "mode");
			MainDispatcher.getInstance().callView(sub_package + "ContentInsert", request);
			break;
			
		case "DELETE":
			id = Integer.parseInt(request.get("id").toString());
			contentService.delete(id);
			request = new Request();
			request.put("mode", "mode");
			MainDispatcher.getInstance().callView(sub_package + "ContentDelete", request);
			break;
			
		case "UPDATE" :
			id = Integer.parseInt(request.get("id").toString());
			title = request.get("title").toString();
			text = request.get("text").toString();
			tag = request.get("tag").toString();
			idStudent = Integer.parseInt(request.get("idStudent").toString());
			Content contenttoupdate = new Content(title, text, tag, idStudent);
			contenttoupdate.setId(id);
			contentService.update(contenttoupdate);
			request = new Request();
			request.put("mode", "mode");
			MainDispatcher.getInstance().callView(sub_package + "ContentUpdate", request);
			break;
			
		case "CONTENTLIST" :
			List<Content> contents = contentService.getAll();
			request.put("contents", contents);
			MainDispatcher.getInstance().callView("Content", request);
			break;
			
		case "GETCHOICE" :
			switch (choice.toUpperCase()) {
			
			case "L":
				MainDispatcher.getInstance().callView(sub_package + "ContentRead", null);
				break;
				
			case "I":
				MainDispatcher.getInstance().callView(sub_package + "ContentInsert", null);
				break;
				
			case "M":
				MainDispatcher.getInstance().callView(sub_package + "ContentUpdate", null);
				break;
				
			case "C":
				MainDispatcher.getInstance().callView(sub_package + "ContentDelete", null);
				break;
				
			case "V":
				request.put("mode", "CONTENTLIST");
				MainDispatcher.getInstance().callAction("Content", "doControl", request);
				
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
	
