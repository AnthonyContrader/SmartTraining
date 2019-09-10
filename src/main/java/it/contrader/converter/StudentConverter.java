package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.StudentDTO;
import it.contrader.model.Student;

public class StudentConverter implements Converter<Student, StudentDTO> {
	
	@Override
	public StudentDTO toDTO(Student student) {
		StudentDTO studentDTO = new StudentDTO(student.getId(), student.getName(), student.getSurname(), student.getIdUser());
		return studentDTO;
	}
	
	@Override
	public Student toEntity(StudentDTO studentDTO) {
		Student student = new Student(studentDTO.getId(), studentDTO.getName(), studentDTO.getSurname(), studentDTO.getIdUser());
		return student;
	}
	
	@Override
	public List<StudentDTO> toDTOList(List<Student> studentList){
		List<StudentDTO> studentDTOList = new ArrayList<StudentDTO>();
		
		for(Student student : studentList) {
			studentDTOList.add(toDTO(student));
		}
		return studentDTOList;
	}
   
}

