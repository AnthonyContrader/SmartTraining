package it.contrader.dto;

public class StudentDTO {
	private int id;
	private String name;
	private String surname;
	private int idUser;
	
	public StudentDTO() {
		
	}
	
	public StudentDTO(String name, String surname, int idUser) {
		this.name = name;
		this.surname = surname;
		this.idUser = idUser;
		
	}
	
	public StudentDTO(int id, String name, String surname, int idUser) {
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.idUser = idUser;
		
	}
	
	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	public String toString() {
		return  id + "\t"  + name +"\t\t" +   surname + "\t\t" + idUser;
	}

}
