package it.contrader.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.contrader.dto.TrainingDTO;
import it.contrader.service.TrainingService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/training")

public class TrainingController extends AbstractController<TrainingDTO>{
	
	@Autowired
	private TrainingService trainingService;

}
