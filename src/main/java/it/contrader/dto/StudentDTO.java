package it.contrader.dto;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import it.contrader.model.User;
import it.contrader.model.User.Usertype;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO della classe {@link User}. Ha gli stessi attributi di User
 * 
 * @author Vittorio Valent
 * @author Girolamo Murdaca
 * 
 *@see User
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
public class StudentDTO {

	private long id;
	
	private String name;
	
	private String surname;
	
	private User user;


}
