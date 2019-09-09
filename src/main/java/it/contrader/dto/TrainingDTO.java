package it.contrader.dto;

public class TrainingDTO {
	
	private int id;
	private String nameTraining;
	private int idGroup;
	private int idStudent;
	
	public TrainingDTO() {
		
	}
	public TrainingDTO(String nameTraining, int idGroup, int idStudent) {
		this.nameTraining=nameTraining;
		this.idGroup=idGroup;
		this.idStudent=idStudent;
	}

	
	public TrainingDTO (int id, String nameTraining, int idGroup, int idStudent) {
		this.id=id;
		this.nameTraining=nameTraining;
		this.idGroup=idGroup;
		this.idStudent=idStudent;
	}
	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id=id;
	}
	public String getNameTraining() {
		return this.nameTraining;
	}
	public void setNameTraining(String nameTraining) {
		this.nameTraining=nameTraining;
	}
	public int getIdGroup() {
		return this.idGroup;
	}
	public void setIdGroup(int idGroup) {
		this.idGroup=idGroup;
	}
	public int getIdStudent() {
		return this.idStudent;
	}
	public void setIdStudent(int idStudent) {
		this.idStudent=idStudent;
		
	}
	public String toString() {
		return  id + "\t"  + nameTraining +"\t\t" +   idGroup + "\t\t" + idStudent;
}


}
