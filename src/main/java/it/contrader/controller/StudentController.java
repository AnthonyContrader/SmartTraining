package it.contrader.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.contrader.dto.StudentDTO;
import it.contrader.model.User;
import it.contrader.service.StudentService;
import it.contrader.service.UserService;

@Controller
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	private StudentService service;
	
	@Autowired
	private UserService uService;
	
	@GetMapping("/getall")
	public String getAll(HttpServletRequest request) {
		setAll(request);
		setAllUser(request);
		return "student/students";
	}
	
	@GetMapping("/delete")
	public String delete(HttpServletRequest request, @RequestParam("id") Long id) {
		service.delete(id);
		setAll(request);
		setAll(request);
		return "student/students";
	}
	
	@GetMapping("/preupdate")
	public String preUpdate(HttpServletRequest request, @RequestParam("id") Long id) {
		request.getSession().setAttribute("dto", service.read(id));
		return "student/updatestudent"; 
	}
	
	@PostMapping("/update")
	public String update(HttpServletRequest request, @RequestParam("id") Long id, @RequestParam("name") String name,
			@RequestParam("surname") String surname, @RequestParam("user") User user) {
		StudentDTO dto = new StudentDTO();
		dto.setId(id);
		dto.setName(name);
		dto.setSurname(surname);
		dto.setUser(user);
		service.update(dto);
		setAll(request);
		setAllUser(request);
		return "student/students";
	}
	
	@PostMapping("/insert")
	public String insert(HttpServletRequest request, @RequestParam("name") String name, 
			@RequestParam("surname") String surname, @RequestParam("user") User user) {
		StudentDTO dto = new StudentDTO();
		dto.setName(name);
		dto.setSurname(surname);
		dto.setUser(user);
		service.insert(dto);
		setAll(request);
		return "student/students";		
	}
	
	@GetMapping("/read")
	public String read(HttpServletRequest request,@RequestParam("id") Long id) {
		request.getSession().setAttribute("dto", service.read(id));
		return "student/readstudent";
	}
	
	@GetMapping("/logout")
	public String logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return "index";
	}
	
	private void setAll(HttpServletRequest request) {
		request.getSession().setAttribute("list", service.getAll());
	}
	private void setAllUser(HttpServletRequest request) {
		request.getSession().setAttribute("Userlist", uService.getAll());
	}

}
