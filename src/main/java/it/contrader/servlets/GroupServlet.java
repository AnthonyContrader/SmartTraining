package it.contrader.servlets;

import java.util.List;



import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import it.contrader.dto.GroupDTO;
import it.contrader.dto.UserDTO;
import it.contrader.service.Service;
import it.contrader.service.GroupService;

public class GroupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public GroupServlet() {
	}
	
	public void updateList(HttpServletRequest request) {
		Service<GroupDTO> service = new GroupService();
		List<GroupDTO>listDTO = service.getAll();
		request.setAttribute("list", listDTO);
	}
	
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		Service<GroupDTO> service = new GroupService();
		String mode = request.getParameter("mode");
		GroupDTO dto;
		int id;
		boolean ans;
		
		Object idStudent;
		switch (mode.toUpperCase()) {
		
		case "GROUPLIST":
			updateList(request);
			getServletContext().getRequestDispatcher("/group/groupmanager.jsp").forward(request, response);
			break;
		
		case "READ":
			id = Integer.parseInt(request.getParameter("id"));
			dto = service.read(id);
			request.setAttribute("dto", dto);
			
			if(request.getParameter("update") == null) {
				getServletContext().getRequestDispatcher("/group/readgroup.jsp").forward(request, response);
				
			}
			else getServletContext().getRequestDispatcher("/group/updategroup.jsp").forward(request, response);
			
			break;
		case "INSERT":
			int idStudent1 = Integer.parseInt(request.getParameter("idStudent"));
			dto = new GroupDTO (idStudent1);
			ans = service.insert(dto);
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/group/groupmanager.jsp").forward(request, response);
			break;
			
		case "UPDATE":
			idStudent1 = Integer.parseInt(request.getParameter("idStudent"));
			id = Integer.parseInt(request.getParameter("id"));
			dto = new GroupDTO (id, idStudent1);
			ans = service.update(dto);
			updateList(request);
			getServletContext().getRequestDispatcher("/group/groupmanager.jsp").forward(request, response);
			break;

		case "DELETE":
			id = Integer.parseInt(request.getParameter("id"));
			ans = service.delete(id);
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/group/groupmanager.jsp").forward(request, response);
			break;
		}
		
	}
}

