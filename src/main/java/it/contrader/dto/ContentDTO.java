package it.contrader.dto;

public class ContentDTO {
	
	private int id;
	
	private String title;
	
	private String text;
	
	private String tag;
	
	private int idStudent;
	
	public ContentDTO() {
		
	}
	
	public ContentDTO(String title, String text, String tag, int idStudent) {
		this.title = title;
		this.tag = tag;
		this.text = text;
		this.idStudent = idStudent;
	}
	
	public ContentDTO(int id, String title, String text, String tag, int idStudent) {
		this.id = id;
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
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getText() {
		return this.text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getTag() {
		return this.tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public int getIdStudent() {
		return this.idStudent;
	}

	public void setIdStudent(int idStudent) {
		this.idStudent = idStudent;
	}
	
	@Override
	public String toString() {
		return  id + "\t"  + title +"\t\t" +   text + "\t\t" + tag +"\t\t" + idStudent;
	}
}
