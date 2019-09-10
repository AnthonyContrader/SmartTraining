package it.contrader.dto;

public class GroupDTO {
	private int id;
	private int idStudent;
	private String groupcol;
	
	public GroupDTO() {
		
	}
	
	public GroupDTO(int idStudent, String groupcol) {
		this.idStudent = idStudent;
		this.groupcol = groupcol;
	}
	public GroupDTO(int id, int idStudent, String groupcol) {
		this.id = id;
		this.idStudent = idStudent;
		this.groupcol = groupcol;
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
	
	public String getGroupcol() {
		return this.groupcol;
	}
	
	public void setGroupcol(String groupcol) {
		this.groupcol = groupcol;
	}
	
	

}
