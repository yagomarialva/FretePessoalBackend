package com.unnt.fretepessoal.controller;

import com.unnt.fretepessoal.dto.PacoteDTO;
import com.unnt.fretepessoal.dto.TransacaoDTO;
import com.unnt.fretepessoal.security.UserSS;
import com.unnt.fretepessoal.services.TransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transacoes")
public class TransacaoController {

    @Autowired
    private TransacaoService service;

    @GetMapping
    public List<TransacaoDTO> list(@RequestParam String query){
        return service.list(query);
    }

    @GetMapping("/atual")
    public TransacaoDTO obterTransacaoAtual() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return service.getAtual(((UserSS) auth.getPrincipal()).getId());
    }

    @GetMapping("/historico")
    public List<TransacaoDTO> obterHistorico() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return service.getHistorico(((UserSS) auth.getPrincipal()).getId());
    }

    @GetMapping("/{id}")
    public TransacaoDTO getOne(@PathVariable Long id) {
        return service.getOne(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TransacaoDTO create(@RequestBody TransacaoDTO aPackage) {
        return service.save(null, aPackage);
    }

    @PutMapping("/{id}")
    public TransacaoDTO update(@PathVariable Long id, @RequestBody TransacaoDTO aPackage) {
        return service.save(id, aPackage);
    }


}
