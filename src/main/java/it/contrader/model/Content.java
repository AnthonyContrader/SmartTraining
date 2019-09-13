package it.contrader.model;
/**
 * Per dettagli vedi guida sez 4 Model
 */
public class Content {

	/**
	 * Qui sotto definisco gli attributi di User. 
	 */
	private int id;

	private String tag;
	
	private String title;
	
	private String text;
	
	private int IdTraining;

	/**
	 * Definisco i due costruttori, uno vuoto e uno con tre parametri per costrire oggetti di tipo User
	 */
	public Content() {
		
	}

	public Content (String tag, String title, String text, int IdTraining) {
		this.tag = tag;
		this.title = title;
		this.text = text;
		this.IdTraining = IdTraining;
	}

	public Content (int id, String tag, String title, String text, int IdTraining) {
		this.id = id;
		this.tag = tag;
		this.title = title;
		this.text = text;
		this.IdTraining = IdTraining;
	}

	/**
	 * Getter e Setter: servono alle altre classi a recuperare e modificare gli attributi di User
	 */
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

	//Trasforma un oggetto in una stringa
	@Override
	public String toString() {
		return  id + "\t"  + tag +"\t\t" +   title + "\t\t" + text +  "\t\t" + IdTraining;
	}

	//Metodo per il confronto degli oggetti
	@SuppressWarnings("unlikely-arg-type")
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
		if (tag == null) {
			if (other.tag != null)
				return false;
		} else if (!tag.equals(other.tag))
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
		if (IdTraining == 0) {
			if (other.IdTraining != 0)
				return false;
		} else if (!(Integer.toString(IdTraining).equals(other.IdTraining)))
			return false;
		return true;
	}
}
