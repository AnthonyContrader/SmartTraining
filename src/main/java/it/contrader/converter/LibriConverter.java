package it.contrader.converter;

import org.springframework.stereotype.Component;

import it.contrader.dto.LibriDTO;
import it.contrader.model.Libri;

@Component

public class LibriConverter extends AbstractConverter<Libri, LibriDTO> {
	public Libri toEntity (LibriDTO libriDTO) {
		Libri libro = null; //oggetto che mando al return
		if (libriDTO!=null) {
			libro=new Libri(libriDTO.getId(), libriDTO.getNome(), libriDTO.getPath(), libriDTO.getCategoria());
			
		}
		return libro;
	}
	public LibriDTO toDTO (Libri libri) {
		LibriDTO libroDTO = null; //oggetto che mando al return
		if (libri!=null) {
			libroDTO=new LibriDTO(libri.getId(), libri.getNome(), libri.getPath(), libri.getCategoria());
			
		} 
		return libroDTO;
	}
	

}
