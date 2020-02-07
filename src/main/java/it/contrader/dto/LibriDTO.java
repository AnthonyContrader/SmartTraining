package it.contrader.dto;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import it.contrader.model.Libri.Categoria; //importa l'enum dalla classe libri
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIdentityInfo (generator=ObjectIdGenerators.PropertyGenerator.class, property="id")

/*@JsonIdentityInfo --> Gestione dei file json, autogestisce gli id istanziati*/

public class LibriDTO {
	
	private long id;
	
	private String nome;
	private String path;
	private Categoria categoria;
	

}
