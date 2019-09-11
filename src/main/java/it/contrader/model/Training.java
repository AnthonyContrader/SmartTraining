package it.contrader.model;

public class Training {
	private int id;
	private String nameTraining;
	private int idGroup;
	
	public Training() {
		
	}
	 public Training (String nameTraining, int idGroup) {
		 this.nameTraining=nameTraining;
		 this.idGroup=idGroup;
	 }
	 
	 public Training (int id, String nameTraining, int idGroup) {
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
	 public void setNameTraining (String nameTraining) {
		 this.nameTraining=nameTraining;
	 }
	 public int getIdGroup() {
		 return this.idGroup;
	 }
	 public void setIdGroup(int idGroup) {
		 this.idGroup=idGroup;
	 }
	
	 public String toString() {
			return  id + "\t"  + nameTraining +"\t\t" +   idGroup;
		}
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
			return true;
		}

}
