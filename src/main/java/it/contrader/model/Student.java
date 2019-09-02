package it.contrader.model;

public class Student {
	private int id;
	private String name;
	private String surname;
	private int idUser;
	
	public Student () {
		
	}
	public Student(String name, String surname, int idUser) {
		super();
		this.name = name;
		this.surname = surname;
		this.idUser = idUser;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
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
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", surname=" + surname + ", idUser=" + idUser + "]";
	}
	
	
	

}
