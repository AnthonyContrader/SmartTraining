package it.contrader.service;

import it.contrader.converter.StudentConverter;
import it.contrader.dao.StudentDAO;
import it.contrader.dto.StudentDTO;
import it.contrader.model.Student;

public class StudentService extends AbstractService<Student, StudentDTO> {
	
	public StudentService() {
		this.dao = new StudentDAO();
		this.converter = new StudentConverter();
	}

}
