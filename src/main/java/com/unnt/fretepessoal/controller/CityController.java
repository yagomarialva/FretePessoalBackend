package com.unnt.fretepessoal.controller;

import com.unnt.fretepessoal.model.City;
import com.unnt.fretepessoal.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cidades")
public class CityController {

    @Autowired
    private CityRepository repo;

    @GetMapping
    public List<City> list(){
        return repo.findAll();
    }

}
