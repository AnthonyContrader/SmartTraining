package it.contrader.model;

public class Group {
	private int id;
	private int idStudent;
	
	
	public Group() {
		
	}


	public Group(int id, int idStudent) {
		super();
		this.id = id;
		this.idStudent = idStudent;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getIdStudent() {
		return idStudent;
	}


	public void setIdStudent(int idStudent) {
		this.idStudent = idStudent;
	}


	@Override
	public String toString() {
		return "Group [id=" + id + ", idStudent=" + idStudent + "]";
	}
	
	
	


}
