package it.contrader.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.contrader.converter.StudentConverter;
import it.contrader.dao.StudentRepository;
import it.contrader.dto.StudentDTO;
import it.contrader.model.Student;

@Service
public class StudentService extends AbstractService<Student, StudentDTO>{
	
	@Autowired
	private StudentConverter converter;
	@Autowired
	private StudentRepository repository;
	
	public StudentDTO findStudentById(Long id) {
		return converter.toDTO(repository.findStudentById(id));
	}

}
