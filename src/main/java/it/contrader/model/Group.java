package it.contrader.model;

public class Group {
	
	private int id;
	
	private int idStudent;
	
	private String groupcol; 
	
	
	public Group() {
		
	}

	public Group (int idStudent, String groupcol) {
		this.idStudent = idStudent;
		this.groupcol = groupcol;
	}
	
	public Group(int id, int idStudent, String groupcol) {
		this.id = id;
		this.idStudent = idStudent;
		this.groupcol = groupcol;
	}


	public int getId() {
		return this.id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getIdStudent() {
		return this.idStudent;
	}


	public void setIdStudent(int idStudent) {
		this.idStudent = idStudent;
	}
	
	public String getGroupcol () {
		return this.groupcol;
	}
	
	public void setGroupcol(String groupcol) {
		this.groupcol = groupcol;
	}


	@Override
	public String toString() {
		return id + "\t" + idStudent + "\t\t" + groupcol;
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
			if (groupcol == null) {
				if (other.groupcol != null)
					return false;
			} else if (!groupcol.equals(other.groupcol))
				return false;
			return true;
		}
}
