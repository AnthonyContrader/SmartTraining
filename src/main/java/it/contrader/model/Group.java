package it.contrader.model;

public class Group {
	private int id;
	private int idStudent;
	
	
	public Group() {
		
	}


	public Group(int id, int idStudent) {
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
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Group other = (Group) obj;
		if (id != other.id)
			return false;
		if (idStudent == 0) {
			if (other.idStudent != 0)
				return false;
		} else if (!(Integer.toString(idStudent).equals(other.idStudent)))
			return false;
		return true;
		}
}
