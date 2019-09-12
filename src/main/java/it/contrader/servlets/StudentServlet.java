package it.contrader.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.contrader.dto.StudentDTO;
import it.contrader.dto.UserDTO;
import it.contrader.service.Service;
import it.contrader.service.StudentService;
import it.contrader.service.UserService;

public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID=1L;
	
	public StudentServlet() {
		
	}
	public void updateList (HttpServletRequest request) {
		Service<StudentDTO> service = new StudentService();
		List<StudentDTO>listDTO = service.getAll();
		request.setAttribute("list", listDTO);
		
		Service<UserDTO> userservice = new UserService();
		List<UserDTO> userlistDTO = userservice.getAll();
		request.setAttribute("listUser", userlistDTO);
	}
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Service<StudentDTO> service = new StudentService();
		String mode = request.getParameter("mode");
		StudentDTO dto;
		int id;
		boolean ans;

		
		switch (mode.toUpperCase()) {
		
		case "STUDENTLIST":
			updateList(request);
			getServletContext().getRequestDispatcher("/student/studentmanager.jsp").forward(request, response);
			break;
			
		
		case "READ":
			id = Integer.parseInt(request.getParameter("id"));
			dto = service.read(id);
			request.setAttribute("dto", dto);
			
			updateList(request);
			getServletContext().getRequestDispatcher("/student/updatestudent.jsp").forward(request, response);
			
			if (request.getParameter("update") == null) {
				 getServletContext().getRequestDispatcher("/student/readstudent.jsp").forward(request, response);
				
			}
			
			else getServletContext().getRequestDispatcher("/student/updatestudent.jsp").forward(request, response);
			break;

		case "INSERT":
			String name = request.getParameter("name").toString();
			String surname = request.getParameter("surname").toString();
			int idUser = (Integer.parseInt(request.getParameter("idUser").toString()));
			dto = new StudentDTO (name,surname,idUser);
			ans = service.insert(dto);
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/student/studentmanager.jsp").forward(request, response);
			break;
			
		case "UPDATE":
			name = request.getParameter("name");
			surname = request.getParameter("surname");
			idUser = Integer.parseInt(request.getParameter("idUser"));
			id = Integer.parseInt(request.getParameter("id"));
			dto = new StudentDTO (id,name, surname, idUser);
			ans = service.update(dto);
			updateList(request);
			getServletContext().getRequestDispatcher("/student/studentmanager.jsp").forward(request, response);
			break;

		case "DELETE":
			id = Integer.parseInt(request.getParameter("id"));
			ans = service.delete(id);
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/student/studentmanager.jsp").forward(request, response);
			break;
		}
	}
}
