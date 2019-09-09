package it.contrader.dto;

public class GroupDTO {
	private int id;
	private int idStudent;
	
	public GroupDTO() {
		
	}
	
	public GroupDTO(int idStudent) {
		this.idStudent = idStudent;
	}
	public GroupDTO(int id, int idStudent) {
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
	
	

}
