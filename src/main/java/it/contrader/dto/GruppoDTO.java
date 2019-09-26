package it.contrader.dto;

import javax.persistence.Entity;

import it.contrader.model.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class GruppoDTO {
	
	private Long id;
	
	private Student student;
	
	private String grupponame;

}
