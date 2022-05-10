package com.unnt.fretepessoal.controller;
import java.util.List;

import javax.persistence.Entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.unnt.fretepessoal.model.Pacote;
import com.unnt.fretepessoal.repository.PacoteRepository;

@RestController
@RequestMapping("/api/v1/pacotes")
public class PacoteController {

	@Autowired
	private PacoteRepository pacoteRepository;


	
	public PacoteController(PacoteRepository pacoteRepository) {
		super();
		this.pacoteRepository = pacoteRepository;
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping
	public List<Pacote> getPacote(){
		return pacoteRepository.findAll();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	@CrossOrigin(origins = "http://localhost:4200")
	public Pacote setPacote(@RequestBody Pacote pacote) {
		return pacoteRepository.save(pacote);
	}

	
}
