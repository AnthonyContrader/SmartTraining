package it.contrader.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ContentDTO {

	private Long id;

	private String tag;

	private String title;

	private String text;
	
	private int idTraining;

}
