package it.contrader.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.contrader.dto.GruppoDTO;
import it.contrader.model.Gruppo;
import it.contrader.service.GruppoService;

@Controller
@RequestMapping("/gruppo")
public class GruppoController {

	@Autowired
	private GruppoService service;


	@GetMapping("/getall")
	public String getAll(HttpServletRequest request) {
		setAll(request);
		return "gruppo/gruppos";
	}

	@GetMapping("/delete")
	public String delete(HttpServletRequest request, @RequestParam("id") Long id) {
		service.delete(id);
		setAll(request);
		return "gruppo/gruppos";
	}

	@GetMapping("/preupdate")
	public String preUpdate(HttpServletRequest request, @RequestParam("id") Long id) {
		request.getSession().setAttribute("dto", service.read(id));
		return "gruppo/updategruppo";
	}

	@PostMapping("/update")
	public String update(HttpServletRequest request, @RequestParam("id") Long id, @RequestParam("idStudent") Long idStudent,
			@RequestParam("gruppo") String grupponame) {

		GruppoDTO dto = new GruppoDTO();
		dto.setId(id);
		dto.setIdStudent(idStudent);
		dto.setGrupponame(grupponame);
		service.update(dto);
		setAll(request);
		return "gruppo/gruppos";

	}

	@PostMapping("/insert")
	public String insert(HttpServletRequest request, @RequestParam("idStudent") Long idStudent,
					@RequestParam("gruppo") String grupponame) {
		GruppoDTO dto = new GruppoDTO();
		dto.setIdStudent(idStudent);
		dto.setGrupponame(grupponame);
		service.insert(dto);
		setAll(request);
		return "gruppo/gruppos";
	}

	@GetMapping("/read")
	public String read(HttpServletRequest request, @RequestParam("id") Long id) {
		request.getSession().setAttribute("dto", service.read(id));
		return "gruppo/readgruppo";
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
