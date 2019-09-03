package it.contrader.service;

import java.util.List;

import it.contrader.dao.StudentDAO;
import it.contrader.model.Student;
import it.contrader.model.User;

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
	public boolean delete(int id) {
		return studentDAO.delete(id);
    }
	public boolean insert(Student student) {
		return studentDAO.insert(student);
	}
	public boolean update(Student student) {
		return studentDAO.update(student);
	}
}