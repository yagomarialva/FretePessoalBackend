package com.unnt.fretepessoal.services;

import com.unnt.fretepessoal.dto.PacoteDTO;
import com.unnt.fretepessoal.model.Pacote;
import com.unnt.fretepessoal.model.enums.PacoteStatus;
import com.unnt.fretepessoal.repository.PacoteRepository;
import com.unnt.fretepessoal.repository.UserRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PacoteService {

    @Autowired
    private PacoteRepository repo;

    @Autowired
    private UserRepository userRepo;

    public List<PacoteDTO> listNovosPacotes() {
        return repo.findByStatus(PacoteStatus.NOVO_PACOTE)
            .stream()
            .map(PacoteDTO::new)
            .collect(Collectors.toList());
    }

    public List<PacoteDTO> list(String query) {
        return (StringUtils.isEmpty(query)
                ? repo.findAll() : repo.findAllByQuery('%' + query + '%')
        ).stream()
                .map(PacoteDTO::new)
                .collect(Collectors.toList());
    }

    public PacoteDTO save(Long id, PacoteDTO aPackage) {
        Pacote user = (id == null)
                ? new Pacote()
                : repo.getById(id);

        user.setDescricao(aPackage.getDescricao());
        user.setIcone(aPackage.getIcone());
        user.setOrigem(aPackage.getOrigem());
        user.setDestino(aPackage.getDestino());
        user.setDono(userRepo.getById(aPackage.getDono()));
        user.setStatus(aPackage.getStatus());
        user.setPeso(aPackage.getPeso());
        user.setPreco(aPackage.getPreco());

        return new PacoteDTO(repo.save(user));
    }

    public PacoteDTO getOne(Long id) {
        return new PacoteDTO(repo.getById(id));
    }

}
