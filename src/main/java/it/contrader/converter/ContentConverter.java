package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.ContentDTO;
import it.contrader.model.Content;




public class ContentConverter implements Converter<Content, ContentDTO> {
	
	@Override
	public ContentDTO toDTO(Content content) {
		ContentDTO contentDTO = new ContentDTO(content.getId(), content.getTitle(), content.getText(), content.getTag(), content.getIdStudent());
		return contentDTO;
	}
	
	public Content toEntity(ContentDTO contentDTO) {
		Content content = new Content(contentDTO.getId(), contentDTO.getTitle(), contentDTO.getText(), contentDTO.getTag(), contentDTO.getIdStudent());
		return content;
	}
	
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
