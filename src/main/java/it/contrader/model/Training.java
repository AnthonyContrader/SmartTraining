package it.contrader.model;

public class Training {
	private int id;
	private String nameTraining;
	private int idGroup;
	private int idStudent;
	
	public Training() {
		
	}
	
	public Training(String nameTraining, int idGroup, int idStudent) {
		this.nameTraining = nameTraining;
		this.idGroup = idGroup;
		this.idStudent = idStudent;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNameTraining() {
		return nameTraining;
	}

	public void setNameTraining(String nameTraining) {
		this.nameTraining = nameTraining;
	}

	public int getIdGroup() {
		return idGroup;
	}

	public void setIdGroup(int idGroup) {
		this.idGroup = idGroup;
	}

	public int getIdStudent() {
		return idStudent;
	}

	public void setIdStudent(int idStudent) {
		this.idStudent = idStudent;
	}
	
	

}
