package com.unnt.fretepessoal.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.unnt.fretepessoal.model.Package;
import com.unnt.fretepessoal.repository.PackageRepository;

@RestController
@RequestMapping("/api/v1/pacotes")
public class PackageController {

	@Autowired
	private PackageRepository packageRepository;


	
	public PackageController(PackageRepository packageRepository) {
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

	
}
