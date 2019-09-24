package it.contrader.converter;

import org.springframework.stereotype.Component;

import it.contrader.dto.StudentDTO;

import it.contrader.model.Student;

/**
 * Questa classe implementa i metodi di conversione dell'entità {@link User} a {@link UserDTO}
 * e viceversa.
 *  
 * @author Vittorio Valent
 * @author Girolamo Murdaca
 * 
 *@see AbstractConverter
 *@see Converter
 */
@Component
public class StudentConverter extends AbstractConverter<Student, StudentDTO> {

	@Override
	public Student toEntity(StudentDTO studentDTO) {
		Student student = null;
		if (studentDTO != null) {
			student = new Student(studentDTO.getId(),studentDTO.getName(),studentDTO.getSurname(),studentDTO.getUser());			
		}
		return student;
	}

	@Override
	public StudentDTO toDTO(Student student) {
		StudentDTO studentDTO = null;
		if (student != null) {
			studentDTO = new StudentDTO(student.getId(),student.getName(),student.getSurname(),student.getUser());
			
		}
		return studentDTO;
	}
}