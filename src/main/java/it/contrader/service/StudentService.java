package it.contrader.service;

import java.util.List;

import it.contrader.dao.StudentDAO;
import it.contrader.model.Student;

public class StudentService {
	
	private StudentDAO studentDAO;
	
	public StudentService() {
		this.studentDAO = new StudentDAO();
	}
	
	public List<Student> getAll() {
		return this.studentDAO.getAll();
	}
	public Student read (int id) {
		return this.studentDAO.read(id);
	}
}	