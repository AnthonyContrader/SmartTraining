package it.contrader.controller;

import it.contrader.main.MainDispatcher;
import it.contrader.model.Content;
import it.contrader.service.ContentService;

public class ContentController implements Controller {
	private static String sub_package = "content";
	
	private ContentService contentService;
	
	public ContentController() {
		this.contentService = new ContentService();
	}
	
	@Override
	public void doControl(Request request) {
		//Estrae mode choice
		String mode = (String) request.get("mode");
		String choise = (String) request.get("choise");
		
		int id;
		String text, title, tag;
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
			idStudent = Integer.parseInt(request.get("idStudent").toString());
			
		}
	}
	

}
