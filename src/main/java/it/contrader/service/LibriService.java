package it.contrader.service;

import java.util.List;

import org.springframework.stereotype.Service;

import it.contrader.dao.LibriRepository;
import it.contrader.dto.LibriDTO;
import it.contrader.model.Libri;
import it.contrader.model.Libri.Categoria;

@Service

public class LibriService extends AbstractService<Libri, LibriDTO> {
	public List<LibriDTO> findByCategoria (Categoria categoria) {
		return converter.toDTOList(((LibriRepository) repository).findByCategoria (categoria));
	}
}
