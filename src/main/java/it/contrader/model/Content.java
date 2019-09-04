package it.contrader.model;

public class Content {
	
	private int Id;
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

public int getid() {
	return Id;
}

public void setid(int id) {
	this.Id = id;
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
	return "Content [id=" + Id + ", title=" + title + ", text=" + text + ", tag=" + tag + ", idStudent=" + idStudent
			+ "]";
}

}





