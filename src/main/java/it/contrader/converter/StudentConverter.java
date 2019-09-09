package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.StudentDTO;
import it.contrader.model.Student;

public class StudentConverter implements Converter<Student, StudentDTO> {
	public StudentDTO toDTO(Student student) {
		StudentDTO studentdto = new StudentDTO(student.getId(), studentDTO.getName(), StudentDTO.getSurname(), studentDTO.getidUser());
		return studentDTO;
	}
	
	public Student toEntety(StudentDTO studentDTO) {
		Student student = new Student(studentDTO.getId(), studentDTO.getName(), studentDTO.getSurname(), studentDTO.getIdUser());
		return student;
	}
	
	public List<StudentDTO> toDTOList(List<Student> studentList){
		List<StudentDTO> studentDTOList = new ArrayList<StudentDTO>();
		
		for(Student student : studentList) {
			studentDTOList.add(toDTO(student));
		}
		return studentDTOList;
	}

	@Override
	public Student toEntity(StudentDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}
   
}

