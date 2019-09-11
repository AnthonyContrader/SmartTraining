package it.contrader.servlets;

import java.util.List;



import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import it.contrader.dto.ContentDTO;
import it.contrader.service.Service;
import it.contrader.service.ContentService;

/*
 * Per dettagli vedi Guida sez Servlet
 */
public class ContentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ContentServlet() {
	}
	
	public void updateList(HttpServletRequest request) {
		Service<ContentDTO> service = new ContentService();
		List<ContentDTO>listDTO = service.getAll();
		request.setAttribute("list", listDTO);
	}

	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Service<ContentDTO> service = new ContentService();
		String mode = request.getParameter("mode");
		ContentDTO dto;
		int id;
		boolean ans;

		switch (mode.toUpperCase()) {

		case "CONTENTLIST":
			updateList(request);
			getServletContext().getRequestDispatcher("/content/contentmanager.jsp").forward(request, response);
			break;

		case "READ":
			id = Integer.parseInt(request.getParameter("id"));
			dto = service.read(id);
			request.setAttribute("dto", dto);
			
			if (request.getParameter("update") == null) {
				 getServletContext().getRequestDispatcher("/content/readcontent.jsp").forward(request, response);
				
			}
			else getServletContext().getRequestDispatcher("/content/updatecontent.jsp").forward(request, response);
			
			break;

		case "INSERT":
			String tag = request.getParameter("tag").toString();
			String title = request.getParameter("title").toString();
			String text = request.getParameter("text").toString();
			int idStudent = Integer.parseInt(request.getParameter("idStudent").toString());
			dto = new ContentDTO (tag,title,text, idStudent);
			ans = service.insert(dto);
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/content/contentmanager.jsp").forward(request, response);
			break;
			
		case "UPDATE":
			tag = request.getParameter("tag");
			title = request.getParameter("title");
			text = request.getParameter("text");
			idStudent = Integer.parseInt(request.getParameter("idStudent"));
			id = Integer.parseInt(request.getParameter("id"));
			System.out.println(id);
			dto = new ContentDTO (id,tag, title, text, idStudent);
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