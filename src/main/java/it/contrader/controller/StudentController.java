package it.contrader.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import it.contrader.dto.StudentDTO;
import it.contrader.service.StudentService;


/**
 * 
 * Questa classe estende AbstractController con tipo {@link UserDTO}.
 * In aggiunta ai metodi di CRUD si implementa il metodo di  login.
 * 
 * @author Vittorio Valent
 * @author Girolamo Murdaca
 * 
 * @param<UserDTO>
 * 
 * @see AbstractController
 *
 */
@RestController
@RequestMapping("/student")
@CrossOrigin(origins = "http://localhost:4200")
public class StudentController extends AbstractController<StudentDTO>{
	
	@Autowired
	private StudentService studentService;


	/**
	 * Riceve una request di tipo POST dal server Angular
	 * con un {@link LoginDTO} nel Body.
	 * 
	 * @param loginDTO
	 * @return UserDTO
	 */

}