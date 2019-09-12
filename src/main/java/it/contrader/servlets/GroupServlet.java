package it.contrader.servlets;

import java.util.List;



import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import it.contrader.dto.GroupDTO;
import it.contrader.dto.StudentDTO;
import it.contrader.service.Service;
import it.contrader.service.StudentService;
import it.contrader.service.GroupService;

public class GroupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public GroupServlet() {
	}
	
	public void updateList(HttpServletRequest request) {
		Service<GroupDTO> service = new GroupService();
		Service<StudentDTO> services = new StudentService();
		List<GroupDTO>listDTO = service.getAll();
		List<StudentDTO>studlistDTO = services.getAll();
		request.setAttribute("list", listDTO);
		request.setAttribute("studlist", studlistDTO);
	}
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		Service<GroupDTO> service = new GroupService();
		String mode = request.getParameter("mode");
		GroupDTO dto;
		int id;
		boolean ans;
		
		switch (mode.toUpperCase()) {
		
		case "GROUPLIST":
			updateList(request);
			getServletContext().getRequestDispatcher("/group/groupmanager.jsp").forward(request, response);
			break;
		
		case "READ":
			id = Integer.parseInt(request.getParameter("id"));
			dto = service.read(id);
			request.setAttribute("dto", dto);

			updateList(request);
			
			if(request.getParameter("update") == null) {
				getServletContext().getRequestDispatcher("/group/readgroup.jsp").forward(request, response);
				
			}
			else getServletContext().getRequestDispatcher("/group/updategroup.jsp").forward(request, response);

			break;
			
		case "INSERT":			
			
			String groupcol = request.getParameter("groupcol").toString();
			int idStudent = Integer.parseInt(request.getParameter("idStudent").toString());
			dto = new GroupDTO (idStudent, groupcol);
			ans = service.insert(dto);
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/group/groupmanager.jsp").forward(request, response);
			break;
			
		case "UPDATE":
			groupcol = request.getParameter("groupcol");
			idStudent = Integer.parseInt(request.getParameter("idStudent").toString());
			id = Integer.parseInt(request.getParameter("id"));
			dto = new GroupDTO (id, idStudent, groupcol);
			//System.out.println("DTO: "+dto.getId()+","+ dto.getIdStudent()+","+dto.getGroupcol());
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

