package com.unnt.fretepessoal.controller;
import java.util.List;

import com.unnt.fretepessoal.dto.PacoteDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.unnt.fretepessoal.model.Package;
import com.unnt.fretepessoal.repository.PackageRepository;


@RestController
@RequestMapping("/api/v1/pacotes")
public class PacoteController {

	@Autowired
	private PackageRepository packageRepository;


	
	public PacoteController(PackageRepository packageRepository) {
		super();
		this.packageRepository = packageRepository;
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping
	public List<Package> getPacote(){
		return packageRepository.findAll();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	@CrossOrigin(origins = "http://localhost:4200")
	public Package setPacote(@RequestBody Package aPackage) {
		return packageRepository.save(aPackage);
	}

	/*PUT*/
//	@PutMapping("/{id}")
//	public ResponseEntity<Package> update(@PathVariable Integer id, @RequestBody PacoteDTO dto){
////      TODO: add @Valid
//		Package body = service.update(id, dto);
//		return ResponseEntity.status(HttpStatus.OK).body(body);
//	}
	
}
