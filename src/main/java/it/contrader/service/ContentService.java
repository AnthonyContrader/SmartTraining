package it.contrader.service;

import it.contrader.converter.ContentConverter;
import it.contrader.dao.ContentDAO;
import it.contrader.dto.ContentDTO;
import it.contrader.model.Content;

/**
 * 
 * @author Vittorio
 *
 *Grazie all'ereditarietà mi basta specificare i tipi di questa classe per
 *ereditare i metodi della clase AbstractService. Pertanto la classe risulta meno complicata
 *da scrivere, facendoci risparmiare tempo e fatica!
 */
public class ContentService extends AbstractService<Content, ContentDTO> {
	
	//Istanzio DAO  e Converter specifici.
	public ContentService(){
		this.dao = new ContentDAO();
		this.converter = new ContentConverter();
	}
	

}
