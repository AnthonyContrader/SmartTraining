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
	
	@Override
	public String toString() {
		return  id + "\t"  + nameTraining +"\t\t" +   idGroup + "\t\t" + idStudent;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Training other = (Training) obj;
		if (id != other.id)
			return false;
		if (nameTraining == null) {
			if (other.nameTraining != null)
				return false;
		} else if (!nameTraining.equals(other.nameTraining))
			return false;
		if (idGroup == 0) {
			if (other.idGroup != 0)
				return false;
		} else if (!(Integer.toString(idGroup).equals(other.idGroup)))
			return false;
		if (idStudent == 0) {
			if (other.idStudent != 0)
				return false;
		} else if (!(Integer.toString(idStudent).equals(other.idStudent)))
			return false;
		return true;
	}
	

}
