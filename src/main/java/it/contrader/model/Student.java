package it.contrader.model;

public class Student{
	private int id;
	private String name;
	private String surname;
	private int idUser;
	
	public Student() {
		
	}
	public Student (String name, String surname, int idUser) {
		this.name=name;
		this.surname=surname;
		this.idUser=idUser;
	}
	
	public Student (int id, String name, String surname, int idUser) {
		this.id=id;
		this.name=name;
		this.surname=surname;
		this.idUser=idUser;
		
	}
	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id=id;
	}
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name=name;
	}
	public String getSurname() {
		return this.surname;
	}
	public void setSurname(String surname) {
		this.surname=surname;
	}
	public int getIdUser() {
		return this.idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser=idUser;
	}
	
	public String toString() {
		return  id + "\t"  + name +"\t\t" +   surname + "\t\t" + idUser;
	}
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (surname == null) {
			if (other.surname != null)
				return false;
		} else if (!surname.equals(other.surname))
			return false;
		if (idUser == 0) {
			if (other.idUser != 0)
				return false;
		} else if (!(Integer.toString(idUser)).equals(other.idUser))
			return false;
		return true;
	}
}


	
