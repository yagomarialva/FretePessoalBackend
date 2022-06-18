package com.unnt.fretepessoal.controller;
import java.util.List;

import com.unnt.fretepessoal.dto.PacoteDTO;
import com.unnt.fretepessoal.services.PacoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.unnt.fretepessoal.model.Pacote;
import com.unnt.fretepessoal.repository.PacoteRepository;


@RestController
@RequestMapping("/pacotes")
public class PacoteController {

	@Autowired
	private PacoteService service;

	@GetMapping
	public List<PacoteDTO> list(@RequestParam String query){
		return service.list(query);
	}

	@GetMapping("/{id}")
	public PacoteDTO getOne(@PathVariable Long id) {
		return service.getOne(id);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public PacoteDTO create(@RequestBody PacoteDTO aPackage) {
		return service.save(null, aPackage);
	}

	@PutMapping("/{id}")
	public PacoteDTO update(@PathVariable Long id, @RequestBody PacoteDTO aPackage) {
		return service.save(id, aPackage);
	}
	
}
