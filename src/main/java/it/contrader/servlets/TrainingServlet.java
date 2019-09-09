package it.contrader.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.contrader.dto.TrainingDTO;
import it.contrader.service.Service;
import it.contrader.service.TrainingService;

public class TrainingServlet extends HttpServlet {
	private static final long serialVersionUID=1L;
	public TrainingServlet() {
		}
	public void updateList(HttpServletRequest request) {
		Service<TrainingDTO> service = new TrainingService();
		List<TrainingDTO>listDTO = service.getAll();
		request.setAttribute("list", listDTO);
	}

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Service<TrainingDTO> service = new TrainingService();
		String mode = request.getParameter("mode");
		TrainingDTO dto;
		int id;
		boolean ans;

		switch (mode.toUpperCase()) {

		case "TRAININGLIST":
			updateList(request);
			getServletContext().getRequestDispatcher("/training/trainingmanager.jsp").forward(request, response);
			break;

		case "READ":
			id = Integer.parseInt(request.getParameter("id"));
			dto = service.read(id);
			request.setAttribute("dto", dto);
			
			if (request.getParameter("update") == null) {
				 getServletContext().getRequestDispatcher("/training/readtraining.jsp").forward(request, response);
				
			}
			
			else getServletContext().getRequestDispatcher("/training/updatetraining.jsp").forward(request, response);
			
			break;

		case "INSERT":
			String nameTraining = request.getParameter("nameTraining").toString();
			int idGroup = Integer.parseInt(request.getParameter("idGroup").toString());
			int idStudent = Integer.parseInt(request.getParameter("idStudent").toString());
			dto = new TrainingDTO (nameTraining,idGroup,idStudent);
			ans = service.insert(dto);
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/training/trainingmanager.jsp").forward(request, response);
			break;
			
		case "UPDATE":
			nameTraining = request.getParameter("nameTraining");
			idGroup = Integer.parseInt(request.getParameter("idGroup"));
			idStudent = Integer.parseInt(request.getParameter("idStudent"));
			id = Integer.parseInt(request.getParameter("id"));
			dto = new TrainingDTO (id,nameTraining, idGroup, idStudent);
			ans = service.update(dto);
			updateList(request);
			getServletContext().getRequestDispatcher("/training/trainingmanager.jsp").forward(request, response);
			break;

		case "DELETE":
			id = Integer.parseInt(request.getParameter("id"));
			ans = service.delete(id);
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/training/trainingmanager.jsp").forward(request, response);
			break;
		}
	}


}
