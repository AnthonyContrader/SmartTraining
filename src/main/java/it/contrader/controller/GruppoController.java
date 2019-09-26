package it.contrader.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.contrader.dto.GruppoDTO;
import it.contrader.service.GruppoService;

@RestController
@RequestMapping("/gruppo")
@CrossOrigin()
public class GruppoController extends AbstractController<GruppoDTO>{
	
	@Autowired
	private GruppoService gruppoService;

}
