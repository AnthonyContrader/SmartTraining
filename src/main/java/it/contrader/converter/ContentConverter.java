package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.ContentDTO;
import it.contrader.model.Content;

/**
 * 
 * @author Vittorio
 * 
 * Implementando questa l'interfaccia converter la classe UserConverter è OBBLIGATA ad implementarne i metodi
 *
 */
public class ContentConverter  implements Converter<Content, ContentDTO> {
	
	/**
	 * Crea un oggetto di tipo UserDTO e lo riempie con i campi del parametro user di tipo User.
	 * Notare l'uso del metodo get() per ottenere il valore dell'attributo-
	 */
	@Override
	public ContentDTO toDTO(Content content) {
		ContentDTO contentDTO = new ContentDTO(content.getId(), content.getTag(), content.getTitle(), content.getText(), content.getIdStudent());
		return contentDTO;
	}

	/**
	 * Crea un oggetto di tipo User e lo riempie con i campi del parametro user di tipo UserDTO.
	 * Notare l'uso del metodo get() per ottenere il valore dell'attributo-
	 */
	@Override
	public Content toEntity(ContentDTO contentDTO) {
		Content content = new Content (contentDTO.getId(), contentDTO.getTag(), contentDTO.getTitle(), contentDTO.getText(), contentDTO.getIdStudent());
		return content;
	}
	
	/**
	 * Metodo per convertire le liste di User.
	 */
	@Override
	public List<ContentDTO> toDTOList(List<Content> contentList) {
		//Crea una lista vuota.
		List<ContentDTO> contentDTOList = new ArrayList<ContentDTO>();
		
		//Cicla tutti gli elementi della lista e li converte uno a uno
		for(Content content : contentList) {
			//Utilizza il metodo toDTO per convertire ogni singolo elemento della lista
			//e lo aggiunge adda lista di DTO
			contentDTOList.add(toDTO(content));
		}
		return contentDTOList;
	}

	
	
}
