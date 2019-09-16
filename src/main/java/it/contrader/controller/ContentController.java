package it.contrader.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.contrader.dto.ContentDTO;
import it.contrader.service.ContentService;

@Controller
@RequestMapping("/content")
public class ContentController {

	@Autowired
	private ContentService service;

	@GetMapping("/getall")
	public String getAll(HttpServletRequest request) {
		setAll(request);
		return "contents";
	}

	@GetMapping("/delete")
	public String delete(HttpServletRequest request, @RequestParam("id") Long id) {
		service.delete(id);
		setAll(request);
		return "contents";
	}

	@GetMapping("/preupdate")
	public String preUpdate(HttpServletRequest request, @RequestParam("id") Long id) {
		request.getSession().setAttribute("dto", service.read(id));
		return "updatecontent";
	}

	@PostMapping("/update")
	public String update(HttpServletRequest request, @RequestParam("id") Long id, @RequestParam("tag") String tag,
			@RequestParam("title") String title, @RequestParam("text") String text, @RequestParam("idTraining") int idTraining) {

		ContentDTO dto = new ContentDTO();
		dto.setId(id);
		dto.setTag(tag);
		dto.setTitle(title);
		dto.setText(text);
		dto.setIdTraining(idTraining);
		service.update(dto);
		setAll(request);
		return "contents";

	}

	@PostMapping("/insert")
	public String insert(HttpServletRequest request, @RequestParam("tag") String tag,
			@RequestParam("title") String title, @RequestParam("text") String text, @RequestParam("idTraining") int idTraining) {
		ContentDTO dto = new ContentDTO();
		dto.setTag(tag);
		dto.setTitle(title);
		dto.setText(text);
		dto.setIdTraining(idTraining);
		service.insert(dto);
		setAll(request);
		return "users";
	}

	@GetMapping("/read")
	public String read(HttpServletRequest request, @RequestParam("id") Long id) {
		request.getSession().setAttribute("dto", service.read(id));
		return "readcontent";
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
