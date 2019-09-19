package it.contrader.dto;

import it.contrader.model.Gruppo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class TrainingDTO {

	private Long id;

	private String nameTraining;

	private Gruppo gruppo;
	
}
