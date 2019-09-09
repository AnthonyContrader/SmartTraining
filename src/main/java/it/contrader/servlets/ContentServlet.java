package it.contrader.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import it.contrader.dto.ContentDTO;
import it.contrader.service.Service;
import it.contrader.service.ContentService;

public class ContentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;  
	
	public ContentServlet() {
	}
	
	public void updateList(HttpServletRequest request) {
		Service<ContentDTO> service = new ContentService();
		List<ContentDTO>listDTO = service.getALL();
		request.setAttribute("list", listDTO);
	}
	
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Service<ContentDTO> service = new ContentService();
		String mode = request.getParameter("mode");
		ContentDTO dto;
		int id;
		boolean ans;
		
		switch (mode.toUpperCase()) {
		
		case "CONTENTLIST":
			updateList(request);
			getServletContext().getRequestDispatcher("/content/contentmanager.jsp").foward(request, response);
			break;
			
		case "READ":
			id = Integer.parseInt(request.getParameter("id"));
			dto = service.read(id);
			request.setAttribute("dto", dto);
			
			if (request.getParameter("update") == null) {
				getServeletContext().getRequestDispatcher("/content/readcontent.jsp").forwars(request, response);
			}
			else getServletContext().getrequestDispatcher("/content/updatecontent.jsp").forward(request, response);
			
			break;
		
		case "INSERT":
			String title = request.getParameter("title").toString();
			String text = request.getParameter("text").toString();
			String tag = request.getParameter("tag").toString();
			int idStudent = Integer.parseInt(request.getParameter("idStudent"));
			dto = new ContentDTO (title, text, tag, idStudent);
			ans = service.insert(dto);
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/content/contentmanager.jsp").forward(request, response);
			break;
		
		case "UPDATE":
			title = request.getParameter("title").toString();
			text = request.getParameter("text").toString();
			tag = request.getParameter("tag").toString();
			idStudent = Integer.parseInt(request.getParameter("idStudent"));
			id = Integer.parseInt(request.getParameter("id"));
			dto = new ContentDTO (id, title, text, tag, idStudent);
			ans = service.update(dto);
			updateList(request);
			getServletContext().getRequestDispatcher("/content/contentmanager.jsp").forward(request, response);
			break;
			
		case "DELETE":
			id = Integer.parseInt(request.getParameter("id"));
			ans = service.delete(id);
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/content/contentmanager.jsp").forward(request, response);
			break;
		}
	}
}
