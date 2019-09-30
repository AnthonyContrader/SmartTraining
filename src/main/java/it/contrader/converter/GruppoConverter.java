package it.contrader.converter;

import org.springframework.stereotype.Component;

import it.contrader.dto.GruppoDTO;
import it.contrader.model.Gruppo;

@Component
public class GruppoConverter extends AbstractConverter<Gruppo, GruppoDTO>{

	@Override
	public Gruppo toEntity(GruppoDTO dto) {
		Gruppo gruppo = null;
		if(dto != null) {
			gruppo = new Gruppo(dto.getId(), dto.getGrupponame(), dto.getStudent());
		}
		return gruppo;
	}

	@Override
	public GruppoDTO toDTO(Gruppo gruppo) {
		GruppoDTO gruppoDTO = null;
		if(gruppo != null) {
			gruppoDTO = new GruppoDTO(gruppo.getId(), gruppo.getGrupponame(), gruppo.getStudent());
		}
		return gruppoDTO;
	}
	
}
