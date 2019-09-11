package it.contrader.dto;

/**
 * 
 * @author Vittorio
 *
 *Il DTO è simile al Model ma può contenere meno attributi (ad esempio d dati sensibili
 *che non devono arrivare alla View). GLi oggetti vengono trasformati da oggetti del Model
 *a oggetti del DTO tramite i Converter (chiamati dai Service). 
 *Per la descrizione della classe far riferimento al Model "User".
 */
public class ContentDTO {
	
	private int id;

	private String tag;
	
	private String title;
	
	private String text;
	
	private int IdTraining;

	
	public ContentDTO() {
		
	}

	public ContentDTO (String tag, String title, String text, int IdTraining) {
		this.tag = tag;
		this.title = title;
		this.text = text;
		this.IdTraining=IdTraining;
	}

	public ContentDTO (int id, String tag, String title, String text, int IdTraining) {
		this.id = id;
		this.tag = tag;
		this.title = title;
		this.text = text;
		this.IdTraining=IdTraining;
	}

	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getTag() {
		return this.tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}


	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getText() {
		return text;
	}
	public int getIdTraining() {
		return this.IdTraining;
	}
	public void setIdTraining(int IdTraining) {
		this.IdTraining = IdTraining;
	}

	@Override
	public String toString() {
		return  id + "\t"  + tag +"\t\t" +   title + "\t\t" + text + "\t\t" + IdTraining;
	}
}
