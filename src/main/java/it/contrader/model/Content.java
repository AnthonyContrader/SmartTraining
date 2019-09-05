package it.contrader.model;

public class Content {
	
	private int id;
	private String title;
	private String text;
	private String tag;
	private int idStudent;

public Content () {
	
}

public Content (String title, String text, String tag, int idStudent) {
	this.title = title;
	this.text = text;
	this.tag = tag;
	this.idStudent = idStudent;
}

public int getId() {
	return this.id;
}

public void setId(int id) {
	this.id = id;
}

public String getTitle() {
	return title;
}

public void setTitle(String title) {
	this.title = title;
}

public String getText() {
	return text;
}

public void setText(String text) {
	this.text = text;
}

public String getTag() {
	return tag;
}

public void setTag(String tag) {
	this.tag = tag;
}

public int getIdStudent() {
	return idStudent;
}

public void setIdStudent(int idStudent) {
	this.idStudent = idStudent;
}

@Override
public String toString() {
	return "Content [id=" + id + ", title=" + title + ", text=" + text + ", tag=" + tag + ", idStudent=" + idStudent
			+ "]";
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Content other = (Content) obj;
	if (id != other.id)
		return false;
	if (title == null) {
		if (other.title != null)
			return false;
	} else if (!title.equals(other.title))
		return false;
	if (text == null) {
		if (other.text != null)
			return false;
	} else if (!text.equals(other.text))
		return false;
	if (tag == null) {
		if (other.tag != null)
			return false;
	} else if (!tag.equals(other.tag))
		return false;
	if (idStudent == 0) {
		if(other.idStudent != 0)
			return false;
	} else if (!(Integer.toString(idStudent).equals(other.idStudent)))
		return false;
	return true;
	}
}





