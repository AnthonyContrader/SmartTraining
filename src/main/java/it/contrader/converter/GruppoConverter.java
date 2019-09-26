package it.contrader.converter;

import it.contrader.dto.GruppoDTO;
import it.contrader.model.Gruppo;

public class GruppoConverter extends AbstractConverter<Gruppo, GruppoDTO>{
	
	@Override
	public Gruppo toEntity(GruppoDTO gruppoDTO) {
		Gruppo gruppo = null;
		if(gruppoDTO != null) {
			gruppo = new Gruppo(gruppoDTO.getId(), gruppoDTO.getStudent(), gruppoDTO.getGrupponame());
		}
		return gruppo;
	}
	
	@Override
	public GruppoDTO toDTO(Gruppo gruppo) {
		GruppoDTO gruppoDTO = null;
		if(gruppo != null) {
			gruppoDTO = new GruppoDTO(gruppo.getId(), gruppo.getStudent(), gruppo.getGrupponame());
		}
		return gruppoDTO;
	}
}
