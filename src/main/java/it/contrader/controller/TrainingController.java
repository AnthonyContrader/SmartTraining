package it.contrader.controller;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.contrader.dto.TrainingDTO;
import it.contrader.service.TrainingService;

@Controller
@RequestMapping("/training")
public class TrainingController {

	@Autowired
	private TrainingService service;

	
	@GetMapping("/getall")
	public String getAll(HttpServletRequest request) {
		setAll(request);
		return "training/trainings";
	}

	@GetMapping("/delete")
	public String delete(HttpServletRequest request, @RequestParam("id") Long id) {
		service.delete(id);
		setAll(request);
		return "training/trainings";
	}

	@GetMapping("/preupdate")
	public String preUpdate(HttpServletRequest request, @RequestParam("id") Long id) {
		request.getSession().setAttribute("dto", service.read(id));
		return "training/updatetraining";
	}

	@PostMapping("/update")
	public String update(HttpServletRequest request, @RequestParam("id") Long id, @RequestParam("nameTraining") String nameTraining,
			@RequestParam("idGroup") int idGroup) {

		TrainingDTO dto = new TrainingDTO();
		dto.setId(id);
		dto.setNameTraining (nameTraining);
		dto.setIdGroup (idGroup);
		service.update(dto);
		setAll(request);
		return "training/trainings";

	}

	@PostMapping("/insert")
	public String insert(HttpServletRequest request, @RequestParam("nameTraining") String nameTraining,
			@RequestParam("idGroup") int idGroup) {
		TrainingDTO dto = new TrainingDTO();
		dto.setNameTraining(nameTraining);
		dto.setIdGroup(idGroup);
		service.insert(dto);
		setAll(request);
		return "training/trainings";
	}

	@GetMapping("/read")
	public String read(HttpServletRequest request, @RequestParam("id") Long id) {
		request.getSession().setAttribute("dto", service.read(id));
		return "training/trainings";
	}

	@GetMapping("/logout")
	public String logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return "index";
	}

	private void setAll(HttpServletRequest request) {
		request.getSession().setAttribute("list", service.getAll());
	}
}
