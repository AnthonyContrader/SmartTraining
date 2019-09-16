package it.contrader.converter;

import org.springframework.stereotype.Component;

import it.contrader.dto.StudentDTO;
import it.contrader.model.Student;

@Component
public class StudentConverter extends AbstractConverter<Student, StudentDTO>{

	@Override
	public Student toEntity(StudentDTO studentDTO) {
		Student student = null;
		if(studentDTO != null) {
			student = new Student(studentDTO.getId(), studentDTO.getName(), studentDTO.getSurname(), studentDTO.getIdUser());
		}
		return student;
	}

	@Override
	public StudentDTO toDTO(Student student) {
		StudentDTO studentDTO = null;
		if(student != null) {
			studentDTO = new StudentDTO(student.getId(), student.getName(), student.getSurname(), student.getIdUser());
		}
		return studentDTO;
	}
	
	

}
