package it.contrader.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor

public class Libri {
	//Gli enum sono indicizzati, quindi php ha indice 0, java ha indice 1 ecc
	public enum Categoria{
		ANGULAR, SPRING,HTML,JAVA,JAVASCRIPT,JSP,PYTHON,MVC,ECLIPSE,MYSQL,
	}
	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	private long id;
	
	private String nome;
	private String path;
	private Categoria categoria;
	

}
