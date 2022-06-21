package com.unnt.fretepessoal.controller;
import java.util.List;

import com.unnt.fretepessoal.dto.PacoteDTO;
import com.unnt.fretepessoal.dto.PacoteDashboardDTO;
import com.unnt.fretepessoal.dto.PacoteInfoDTO;
import com.unnt.fretepessoal.dto.TransacaoDTO;
import com.unnt.fretepessoal.security.UserSS;
import com.unnt.fretepessoal.services.PacoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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

	@GetMapping("/novos")
	public List<PacoteDTO> listNovosPacotes() {
		return service.listNovosPacotes();
	}

	@GetMapping("/disponiveis")
	public List<PacoteDTO> listarDisponiveis(@RequestParam Long origem, @RequestParam Long destino) {
		return service.litarDisponiveis(origem, destino);
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

	@GetMapping("/ativos")
	public List<PacoteDTO> obterAtivos() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		return service.getAtivos(((UserSS) auth.getPrincipal()).getId());
	}

	@GetMapping("/historico")
	public List<PacoteDTO> obterHistorico() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		return service.getHistorico(((UserSS) auth.getPrincipal()).getId());
	}

	@GetMapping("/dashboard")
	public PacoteDashboardDTO obterDashboard() {
		return service.getDashboard();
	}

}
