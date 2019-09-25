package it.contrader.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.contrader.converter.StudentConverter;
import it.contrader.dao.StudentRepository;
import it.contrader.dto.StudentDTO;
import it.contrader.model.Student;

/**
 * Estende AbstractService con parametri {@link User} e {@link UserDTO}.
 * Implementa il metodo di login ed eredita quelli Abstract.
 * 
 * @author Vittorio Valent
 * @author Girolamo Murdaca
 * 
 * @see AbstractService
 * @see ServiceDTO
 */
@Service
public class StudentService extends AbstractService<Student, StudentDTO> {
	@Autowired
	private StudentConverter converter;
	@Autowired
	private StudentRepository repository;

	// ALL crud methods in AbstractService

	// LOGIN method
	public StudentDTO findStudentById(Long id) {
		return converter.toDTO(repository.findStudentById(id));
	}

}
