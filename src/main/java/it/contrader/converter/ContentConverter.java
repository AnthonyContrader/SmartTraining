package it.contrader.converter;

import org.springframework.stereotype.Component;

import it.contrader.dto.ContentDTO;

import it.contrader.model.Content;

@Component
public class ContentConverter extends AbstractConverter<Content, ContentDTO> {

	@Override
	public Content toEntity(ContentDTO contentDTO) {
		Content content = null;
		if (contentDTO != null) {
			content = new Content(contentDTO.getId(), contentDTO.getTag(), contentDTO.getTitle(), contentDTO.getText(), contentDTO.getIdTraining());
		}
		return content;
	}

	@Override
	public ContentDTO toDTO(Content content) {
		ContentDTO contentDTO = null;
		if (content != null) {
			contentDTO = new ContentDTO(content.getId(), content.getTag(), content.getTitle(), content.getText(), content.getIdTraining());

		}
		return contentDTO;
	}

}