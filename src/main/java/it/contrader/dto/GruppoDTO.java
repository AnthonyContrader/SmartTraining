package it.contrader.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class GruppoDTO {

	private Long id;

	private Long idStudent;

	private String grupponame;

}
