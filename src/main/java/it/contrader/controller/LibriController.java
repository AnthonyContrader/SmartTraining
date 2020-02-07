package it.contrader.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.contrader.dto.LibriDTO;
import it.contrader.model.Libri.Categoria;
import it.contrader.service.LibriService;

@RestController
@RequestMapping("/libri")
@CrossOrigin(origins="http://localhost:4200")


public class LibriController extends AbstractController<LibriDTO> {
	@Autowired
	private LibriService libriservice;
	
	@GetMapping(value="/findByCategoria")
	
	public List<LibriDTO> findByCategoria (String categoria){
		return libriservice.findByCategoria(Enum.valueOf(Categoria.class, categoria));
		
	}
}
