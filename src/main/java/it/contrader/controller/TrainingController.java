package it.contrader.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.contrader.dto.TrainingDTO;
import it.contrader.model.Gruppo;
import it.contrader.service.GruppoService;
import it.contrader.service.TrainingService;

@Controller
@RequestMapping("/training")
public class TrainingController {

	@Autowired
	private TrainingService service;
	
	@Autowired
	private GruppoService gService;

	
	@GetMapping("/getall")
	public String getAll(HttpServletRequest request) {
		setAll(request);
		setAllGruppo(request);
		return "training/trainings";
	}

	@GetMapping("/delete")
	public String delete(HttpServletRequest request, @RequestParam("id") Long id) {
		service.delete(id);
		setAll(request);
		setAllGruppo(request);
		return "training/trainings";
	}

	@GetMapping("/preupdate")
	public String preUpdate(HttpServletRequest request, @RequestParam("id") Long id) {
		request.getSession().setAttribute("dto", service.read(id));
		return "training/updatetraining";
	}

	@PostMapping("/update")
	public String update(HttpServletRequest request, @RequestParam("id") Long id, @RequestParam("nameTraining") String nameTraining, @RequestParam("gruppo") Gruppo gruppo) {
		TrainingDTO dto = new TrainingDTO();
		dto.setId(id);
		dto.setNameTraining (nameTraining);
		dto.setGruppo(gruppo);
		service.update(dto);
		setAll(request);
		setAllGruppo(request);
		return "training/trainings";

	}

	@PostMapping("/insert")
	public String insert(HttpServletRequest request, @RequestParam("nameTraining") String nameTraining, @RequestParam ("gruppo") Gruppo gruppo) {
		TrainingDTO dto = new TrainingDTO();
		dto.setNameTraining(nameTraining);
		dto.setGruppo(gruppo);
		service.insert(dto);
		setAll(request);
		return "training/trainings";
	}

	@GetMapping("/read")
	public String read(HttpServletRequest request, @RequestParam("id") Long id, @RequestParam("gruppo") String gruppo) {
		request.getSession().setAttribute("dto", service.read(id));
		return "training/readtraining";
	}

	@GetMapping("/logout")
	public String logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return "index";
	}
	private void setAll(HttpServletRequest request) {
		request.getSession().setAttribute("list", service.getAll());
	}
		
	private void setAllGruppo(HttpServletRequest request) {
		request.getSession().setAttribute("Gruppolist", gService.getAll());
	}
}
