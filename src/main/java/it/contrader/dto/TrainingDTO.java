package it.contrader.dto;

public class TrainingDTO {
	
	private int id;
	private String nameTraining;
	private int idGroup;
	
	public TrainingDTO() {
		
	}
	public TrainingDTO(String nameTraining, int idGroup) {
		this.nameTraining=nameTraining;
		this.idGroup=idGroup;
	}

	
	public TrainingDTO (int id, String nameTraining, int idGroup) {
		this.id=id;
		this.nameTraining=nameTraining;
		this.idGroup=idGroup;
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
	
	public String toString() {
		return  id + "\t"  + nameTraining +"\t\t" +   idGroup + "\t\t";
}


}
