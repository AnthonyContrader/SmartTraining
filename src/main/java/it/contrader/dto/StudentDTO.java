package it.contrader.dto;

import it.contrader.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class StudentDTO {
	
	private Long id;
	
	private String name;
	
	private String surname;
	
	private User user;

}
